package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.OrderBuilderImpl
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface CanPrecedeOrder<T : Table, C : ConditionBuilder<T, C>> : ShouldFillContext<T, C> {
    fun orderBy(): OrderBuilder<T, C> = OrderBuilderImpl(ctx).also { fillContext() }
}