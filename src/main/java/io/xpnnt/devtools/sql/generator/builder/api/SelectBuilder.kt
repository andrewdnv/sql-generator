package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface SelectBuilder<T : Table, C : ConditionBuilder<T, C>> : ClauseBuilder<T, C>, CanChooseColumns<SelectBuilder<T, C>>, CanHaveConditions<T, C>, CanPrecedeOrder<T, C> {

    fun expression(expression: String, alias: String): T

}