package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.GroupBuilderImpl
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder

interface CanPrecedeGroup<CB : ConditionBuilder<CB>> : ShouldFillContext<CB> {
    fun groupBy(): GroupBuilder<CB> = GroupBuilderImpl(ctx).also { fillContext() }
}