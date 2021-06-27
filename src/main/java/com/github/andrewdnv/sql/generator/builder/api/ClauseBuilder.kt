package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder

interface ClauseBuilder<CB : ConditionBuilder<CB>> : CanGenerateSql<CB> {
    fun build()

    override fun fillContext() = build()
}