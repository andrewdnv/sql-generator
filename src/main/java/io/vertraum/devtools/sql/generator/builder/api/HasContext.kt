package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.context.Context
import io.vertraum.devtools.sql.generator.table.spi.Table

interface HasContext<T : Table, C : ConditionBuilder<T, C>> {
    val ctx: Context<T, C>

    fun fillContext()
}

typealias ShouldFillContext<T, C> = HasContext<T, C>