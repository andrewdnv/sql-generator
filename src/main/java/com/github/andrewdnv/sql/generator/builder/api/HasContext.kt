package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.Context
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

interface HasContext<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> {
    val ctx: Context<TF, CB>

    fun fillContext()
}

typealias ShouldFillContext<TF, CB> = HasContext<TF, CB>