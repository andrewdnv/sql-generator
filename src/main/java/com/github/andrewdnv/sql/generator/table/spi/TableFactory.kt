package com.github.andrewdnv.sql.generator.table.spi

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext

interface TableFactory<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> {
    fun table(): Table

    fun conditionBuilder(ctx: SqlContext<TF, CB>): CB
}