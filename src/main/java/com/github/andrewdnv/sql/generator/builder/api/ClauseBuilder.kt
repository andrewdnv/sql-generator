package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

interface ClauseBuilder<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : CanGenerateSql<TF, CB> {
    fun build()

    override fun fillContext() = build()
}