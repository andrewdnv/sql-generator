package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder

interface SelectBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB>, CanChooseColumns<SelectBuilder<CB>>, CanHaveConditions<CB>, CanPrecedeGroup<CB>, CanPrecedeOrder<CB> {

    fun expression(expression: String, alias: String, paramName: String): SelectBuilder<CB>

}