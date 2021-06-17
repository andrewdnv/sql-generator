package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface InsertBuilder<T : Table, C : ConditionBuilder<T, C>> : ClauseBuilder<T, C>, CanChooseColumns<InsertBuilder<T, C>> {
    // TODO: implement
}