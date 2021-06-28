package com.github.andrewdnv.sql.generator.builder.spi

import com.github.andrewdnv.sql.generator.builder.api.CanPrecedeGroup
import com.github.andrewdnv.sql.generator.builder.api.CanPrecedeOrder
import com.github.andrewdnv.sql.generator.builder.api.ClauseBuilder
import com.github.andrewdnv.sql.generator.condition.Condition
import com.github.andrewdnv.sql.generator.context.option.ConditionOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.table.spi.TableFactory
import com.github.andrewdnv.sql.generator.task.print.ResultConditionPrintTask

interface ConditionBuilder<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : ClauseBuilder<TF, CB>, CanPrecedeGroup<TF, CB>, CanPrecedeOrder<TF, CB> {
    val conditions: MutableList<Condition>

    override fun build() {
        val conditionClause = ResultConditionPrintTask(ctx.optionMap, conditions).print()
        val conditionTypeValue = ctx.optionMap[OptionName.CONDITION_TYPE]
        if (conditionTypeValue == ConditionOption.HAVING.value) {
            ctx.havingClause = conditionClause
        } else {
            ctx.whereClause = conditionClause
        }
        conditions.clear()
    }

}