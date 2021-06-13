package io.xpnnt.devtools.sql.generator.builder.spi

import io.xpnnt.devtools.sql.generator.builder.api.CanPrecedeOrder
import io.xpnnt.devtools.sql.generator.builder.api.AdditionalClauseBuilder
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface ConditionBuilder<T : Table, C : ConditionBuilder<T, C>> : AdditionalClauseBuilder<T, C>, CanPrecedeOrder<T, C> {
    // TODO: implement
}