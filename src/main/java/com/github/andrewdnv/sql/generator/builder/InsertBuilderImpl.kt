package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.api.InsertBuilder
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.task.print.InsertPrintTask

class InsertBuilderImpl<CB : ConditionBuilder<CB>>(override val ctx: SqlContext<CB>) : InsertBuilder<CB> {

    override val columns = mutableListOf<Column>()

    override fun column(column: Column): InsertBuilder<CB> {
        columns.add(column)
        return this
    }

    override fun columns(vararg columns: Column): InsertBuilder<CB> {
        this.columns.addAll(columns)
        return this
    }

    override fun allColumns(): InsertBuilder<CB> {
        columns.clear()
        columns.addAll(ctx.table.allColumns())
        return this
    }

    override fun build() {
        ctx.mainClause = InsertPrintTask(ctx.optionMap, columns, ctx.table).print()
    }

}