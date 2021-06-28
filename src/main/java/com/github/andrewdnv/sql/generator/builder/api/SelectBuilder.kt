package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.table.spi.SimpleTable

interface SelectBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB>, CanChooseColumns<SelectBuilder<CB>>, CanHaveConditions<CB>, CanPrecedeGroup<CB>, CanPrecedeOrder<CB> {

    fun expression(table: SimpleTable?, expression: String, alias: String, paramName: String): SelectBuilder<CB>

}