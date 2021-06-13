package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface CanHaveConditions<T : Table, C : ConditionBuilder<T, C>> : ShouldFillContext<T, C> {
    fun where(): C = ctx.conditionBuilder.also { fillContext() }
}