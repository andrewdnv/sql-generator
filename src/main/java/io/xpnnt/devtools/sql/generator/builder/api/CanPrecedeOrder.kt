package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.OrderBuilderImpl
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder

interface CanPrecedeOrder<CB : ConditionBuilder<CB>> : ShouldFillContext<CB> {
    fun orderBy(): OrderBuilder<CB> = OrderBuilderImpl(ctx).also { fillContext() }
}