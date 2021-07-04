@file:Suppress("UNCHECKED_CAST")

package com.github.andrewdnv.sql.generator.builder.spi

import com.github.andrewdnv.sql.generator.builder.api.CanPrecedeGroup
import com.github.andrewdnv.sql.generator.builder.api.CanPrecedeOrder
import com.github.andrewdnv.sql.generator.builder.api.ClauseBuilder
import com.github.andrewdnv.sql.generator.condition.Condition
import com.github.andrewdnv.sql.generator.condition.ConditionType
import com.github.andrewdnv.sql.generator.context.option.ConnectorOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.table.spi.TableFactory
import com.github.andrewdnv.sql.generator.task.print.ResultConditionPrintTask

interface ConditionBuilder<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : ClauseBuilder<TF, CB>, CanPrecedeGroup<TF, CB>, CanPrecedeOrder<TF, CB> {
    val type: ConditionType

    val conditions: MutableList<Condition>

    fun atLeastOneOf(): CB {
        ctx.optionMap.put(OptionName.RESULT_COMPARISON_CONNECTOR, ConnectorOption.OR.value)
        return this as CB
    }

    fun allOf(): CB {
        ctx.optionMap.put(OptionName.RESULT_COMPARISON_CONNECTOR, ConnectorOption.AND.value)
        return this as CB
    }

    override fun build() {
        val conditionClause = ResultConditionPrintTask(ctx.optionMap, type, conditions).print()
        if (type == ConditionType.HAVING) {
            ctx.havingClause = conditionClause
        } else {
            ctx.whereClause = conditionClause
        }
    }

}