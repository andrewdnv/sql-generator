package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder

interface DeleteBuilder<T : ConditionBuilder> : CommandBuilder, CanHaveConditions<T> {
    // TODO: implement
}