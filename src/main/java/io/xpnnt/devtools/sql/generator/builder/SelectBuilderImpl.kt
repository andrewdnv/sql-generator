package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.SelectBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.PseudoColumn
import io.xpnnt.devtools.sql.generator.task.print.SelectPrintTask

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

    override fun expression(expression: String, alias: String, paramName: String): SelectBuilder<CB> {
        columns.add(PseudoColumn(ctx.table, expression, alias))
        return this
    }

    override fun build() {
        ctx.mainClause = SelectPrintTask(ctx.optionMap, columns, ctx.table).print()
    }

}