package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder

interface UpdateBuilder<T : ConditionBuilder> : CommandBuilder, CanChooseColumns<UpdateBuilder<T>>, CanHaveConditions<T> {
    // TODO: implement
}