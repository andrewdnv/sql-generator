package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder

interface SelectBuilder<T : ConditionBuilder> : MainClauseBuilder, CanChooseColumns<SelectBuilder<T>>, CanHaveConditions<T>, CanPrecedeOrder {
    // TODO: implement
}