package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.table.spi.Table

interface UpdateBuilder<T : Table, C : ConditionBuilder<T, C>> : MainClauseBuilder, CanChooseColumns<UpdateBuilder<T, C>>, CanHaveConditions<T, C> {
    // TODO: implement
}