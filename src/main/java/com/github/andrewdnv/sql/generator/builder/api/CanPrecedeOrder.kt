package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.OrderBuilderImpl
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder

interface CanPrecedeOrder<CB : ConditionBuilder<CB>> : ShouldFillContext<CB> {
    fun orderBy(): OrderBuilder<CB> = OrderBuilderImpl(ctx).also { fillContext() }
}