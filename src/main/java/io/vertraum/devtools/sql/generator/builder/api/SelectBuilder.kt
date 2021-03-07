package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder

interface SelectBuilder<T : ConditionBuilder> : QueryBuilder, CanChooseColumns<SelectBuilder<T>>, CanHaveConditions<T>, CanPrecedeOrder {
    // TODO: implement
}