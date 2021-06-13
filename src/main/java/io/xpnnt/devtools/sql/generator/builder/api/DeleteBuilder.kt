package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface DeleteBuilder<T : Table, C : ConditionBuilder<T, C>> : MainClauseBuilder<T, C>, CanHaveConditions<T, C> {
    // TODO: implement
}