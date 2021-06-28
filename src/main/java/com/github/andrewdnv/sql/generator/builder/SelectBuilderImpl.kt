package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.api.SelectBuilder
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.PseudoColumn
import com.github.andrewdnv.sql.generator.table.spi.SimpleTable
import com.github.andrewdnv.sql.generator.table.spi.TableFactory
import com.github.andrewdnv.sql.generator.task.print.SelectPrintTask

class SelectBuilderImpl<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>>(override val ctx: SqlContext<TF, CB>) : SelectBuilder<TF, CB> {

    override val columns = mutableListOf<Column>()

    override fun column(column: Column): SelectBuilder<TF, CB> {
        columns.add(column)
        return this
    }

    override fun columns(vararg columns: Column): SelectBuilder<TF, CB> {
        this.columns.addAll(columns)
        return this
    }

    override fun allColumns(): SelectBuilder<TF, CB> {
        columns.clear()
        columns.addAll(ctx.table().allColumns())
        return this
    }

    override fun expression(table: SimpleTable?, expression: String, alias: String, paramName: String): SelectBuilder<TF, CB> {
        val ctxTable = ctx.table()
        val parentTable = if (table == null && ctxTable is SimpleTable) ctxTable else table
        columns.add(PseudoColumn(parentTable, expression, alias))
        return this
    }

    override fun build() {
        ctx.mainClause = SelectPrintTask(ctx.optionMap, columns, ctx.table()).print()
    }

}