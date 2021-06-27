package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.InsertBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.task.print.InsertPrintTask

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