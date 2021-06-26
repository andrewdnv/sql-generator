package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.GroupBuilderImpl
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface CanPrecedeGroup<T : Table, C : ConditionBuilder<T, C>> : ShouldFillContext<T, C> {
    fun groupBy(): GroupBuilder<T, C> = GroupBuilderImpl(ctx).also { fillContext() }
}