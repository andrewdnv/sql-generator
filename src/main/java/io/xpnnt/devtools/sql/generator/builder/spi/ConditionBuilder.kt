package io.xpnnt.devtools.sql.generator.builder.spi

import io.xpnnt.devtools.sql.generator.builder.api.CanPrecedeOrder
import io.xpnnt.devtools.sql.generator.builder.api.ClauseBuilder
import io.xpnnt.devtools.sql.generator.condition.Condition
import io.xpnnt.devtools.sql.generator.table.spi.Table
import io.xpnnt.devtools.sql.generator.task.print.ResultConditionPrintTask

interface ConditionBuilder<T : Table, C : ConditionBuilder<T, C>> : ClauseBuilder<T, C>, CanPrecedeOrder<T, C> {
    val conditions: MutableList<Condition>

    override fun build() {
        ctx.conditionClause = ResultConditionPrintTask(ctx.optionMap, conditions).print()
    }
}