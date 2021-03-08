package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.table.spi.Table

interface SelectBuilder<T : Table, C : ConditionBuilder<T, C>> : MainClauseBuilder, CanChooseColumns<SelectBuilder<T, C>>, CanHaveConditions<T, C>, CanPrecedeOrder {
    // TODO: implement
}