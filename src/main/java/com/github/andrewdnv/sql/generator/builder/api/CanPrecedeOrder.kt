package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.OrderBuilderImpl
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

interface CanPrecedeOrder<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : ShouldFillContext<TF, CB> {
    fun orderBy(): OrderBuilder<TF, CB> = OrderBuilderImpl(ctx).also { fillContext() }
}