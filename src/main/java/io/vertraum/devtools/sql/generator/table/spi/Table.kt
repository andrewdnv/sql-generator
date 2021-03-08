package io.vertraum.devtools.sql.generator.table.spi

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.context.Context

interface Table<T : ConditionBuilder> {
    fun conditionBuilder(ctx: Context): T
}