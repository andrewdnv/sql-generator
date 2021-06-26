package io.xpnnt.devtools.sql.generator.builder.spi

import io.xpnnt.devtools.sql.generator.builder.api.CanPrecedeGroup
import io.xpnnt.devtools.sql.generator.builder.api.CanPrecedeOrder
import io.xpnnt.devtools.sql.generator.builder.api.ClauseBuilder
import io.xpnnt.devtools.sql.generator.condition.Condition
import io.xpnnt.devtools.sql.generator.context.option.ConditionOption
import io.xpnnt.devtools.sql.generator.context.option.OptionName
import io.xpnnt.devtools.sql.generator.table.spi.Table
import io.xpnnt.devtools.sql.generator.task.print.ResultConditionPrintTask

interface ConditionBuilder<T : Table, C : ConditionBuilder<T, C>> : ClauseBuilder<T, C>, CanPrecedeGroup<T, C>, CanPrecedeOrder<T, C> {
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