package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

interface CanGenerateSql<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : ShouldFillContext<TF, CB> {
    fun generateSql(): String = fillContext().run { ctx.sql() }
}