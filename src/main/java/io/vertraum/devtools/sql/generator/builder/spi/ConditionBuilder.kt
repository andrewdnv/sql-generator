package io.vertraum.devtools.sql.generator.builder.spi

import io.vertraum.devtools.sql.generator.builder.api.CanPrecedeOrder
import io.vertraum.devtools.sql.generator.builder.api.AdditionalClauseBuilder
import io.vertraum.devtools.sql.generator.table.spi.Table

interface ConditionBuilder<T : Table, C : ConditionBuilder<T, C>> : AdditionalClauseBuilder, CanPrecedeOrder {
    val table: Table
    // TODO: implement
}