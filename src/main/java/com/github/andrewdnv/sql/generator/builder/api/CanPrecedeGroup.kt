package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.GroupBuilderImpl
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

interface CanPrecedeGroup<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : ShouldFillContext<TF, CB> {
    fun groupBy(): GroupBuilder<TF, CB> = GroupBuilderImpl(ctx).also { fillContext() }
}