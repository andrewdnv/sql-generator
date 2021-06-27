package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.GroupBuilderImpl
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder

interface CanPrecedeGroup<CB : ConditionBuilder<CB>> : ShouldFillContext<CB> {
    fun groupBy(): GroupBuilder<CB> = GroupBuilderImpl(ctx).also { fillContext() }
}