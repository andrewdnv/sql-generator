package io.vertraum.devtools.sql.generator.builder.spi

import io.vertraum.devtools.sql.generator.builder.api.CanGenerateSql
import io.vertraum.devtools.sql.generator.builder.api.CanPrecedeOrder

interface ConditionBuilder : CanPrecedeOrder, CanGenerateSql {
    // TODO: implement
}