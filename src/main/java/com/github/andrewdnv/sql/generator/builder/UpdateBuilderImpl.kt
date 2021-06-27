package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.api.UpdateBuilder
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.task.print.UpdatePrintTask

class UpdateBuilderImpl<CB : ConditionBuilder<CB>>(override val ctx: SqlContext<CB>) : UpdateBuilder<CB> {

    override val columns = mutableListOf<Column>()

    override fun column(column: Column): UpdateBuilder<CB> {
        columns.add(column)
        return this
    }

    override fun columns(vararg columns: Column): UpdateBuilder<CB> {
        this.columns.addAll(columns)
        return this
    }

    override fun allColumns(): UpdateBuilder<CB> {
        columns.clear()
        columns.addAll(ctx.table.allColumns())
        return this
    }

    override fun build() {
        ctx.mainClause = UpdatePrintTask(ctx.optionMap, columns, ctx.table).print()
    }

}