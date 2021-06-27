package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder

interface CanGenerateSql<CB : ConditionBuilder<CB>> : ShouldFillContext<CB> {
    fun generateSql(): String = fillContext().run { ctx.sql() }
}