package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.Context

interface HasContext<CB : ConditionBuilder<CB>> {
    val ctx: Context<CB>

    fun fillContext()
}

typealias ShouldFillContext<CB> = HasContext<CB>