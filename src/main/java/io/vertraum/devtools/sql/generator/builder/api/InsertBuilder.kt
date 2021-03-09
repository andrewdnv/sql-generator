package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.table.spi.Table

interface InsertBuilder<T : Table, C : ConditionBuilder<T, C>> : MainClauseBuilder<T, C> {
    // TODO: implement
}