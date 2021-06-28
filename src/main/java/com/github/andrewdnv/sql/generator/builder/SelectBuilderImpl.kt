package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.api.SelectBuilder
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.PseudoColumn
import com.github.andrewdnv.sql.generator.table.spi.SimpleTable
import com.github.andrewdnv.sql.generator.task.print.SelectPrintTask

class SelectBuilderImpl<CB : ConditionBuilder<CB>>(override val ctx: SqlContext<CB>) : SelectBuilder<CB> {

    override val columns = mutableListOf<Column>()

    override fun column(column: Column): SelectBuilder<CB> {
        columns.add(column)
        return this
    }

    override fun columns(vararg columns: Column): SelectBuilder<CB> {
        this.columns.addAll(columns)
        return this
    }

    override fun allColumns(): SelectBuilder<CB> {
        columns.clear()
        columns.addAll(ctx.table.allColumns())
        return this
    }

    override fun expression(table: SimpleTable?, expression: String, alias: String, paramName: String): SelectBuilder<CB> {
        val parentTable = if (table == null && ctx.table is SimpleTable) ctx.table else null
        columns.add(PseudoColumn(parentTable, expression, alias))
        return this
    }

    override fun build() {
        ctx.mainClause = SelectPrintTask(ctx.optionMap, columns, ctx.table).print()
    }

}