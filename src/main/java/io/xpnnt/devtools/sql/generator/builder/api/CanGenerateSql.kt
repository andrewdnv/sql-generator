package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface CanGenerateSql<T : Table, C : ConditionBuilder<T, C>> : ShouldFillContext<T, C> {
    // TODO: implement
}