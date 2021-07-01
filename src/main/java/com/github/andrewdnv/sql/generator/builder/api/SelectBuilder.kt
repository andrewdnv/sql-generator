package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.table.spi.SimpleTable
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

interface SelectBuilder<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : ClauseBuilder<TF, CB>, CanChooseColumns<SelectBuilder<TF, CB>>, CanPrecedeWhereConditions<TF, CB>, CanPrecedeGroup<TF, CB>, CanPrecedeOrder<TF, CB> {

    fun expression(table: SimpleTable?, expression: String, alias: String, paramName: String): SelectBuilder<TF, CB>

}