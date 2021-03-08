package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.table.spi.Table

interface DeleteBuilder<T : Table, C : ConditionBuilder<T, C>> : MainClauseBuilder, CanHaveConditions<T, C> {
    // TODO: implement
}