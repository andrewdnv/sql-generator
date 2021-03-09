package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.table.spi.Table

interface CanGenerateSql<T : Table, C : ConditionBuilder<T, C>> : ShouldFillContext<T, C> {
    // TODO: implement
}