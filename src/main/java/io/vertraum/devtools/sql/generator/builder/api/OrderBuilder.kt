package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.table.spi.Table

interface OrderBuilder<T : Table, C : ConditionBuilder<T, C>> : AdditionalClauseBuilder<T, C> {
    // TODO: implement
}