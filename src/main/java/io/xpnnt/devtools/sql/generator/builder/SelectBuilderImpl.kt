package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.SelectBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.PseudoColumn
import io.xpnnt.devtools.sql.generator.table.spi.Table
import io.xpnnt.devtools.sql.generator.task.print.SelectPrintTask

class SelectBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: SqlContext<T, C>) : SelectBuilder<T, C> {

    override val columns = mutableListOf<Column>()

    override fun column(column: Column): SelectBuilder<T, C> {
        columns.add(column)
        return this
    }

    override fun columns(vararg columns: Column): SelectBuilder<T, C> {
        this.columns.addAll(columns)
        return this
    }

    override fun allColumns(): SelectBuilder<T, C> {
        columns.clear()
        columns.addAll(ctx.table.allColumns())
        return this
    }

    override fun expression(expression: String, alias: String, paramName: String): SelectBuilder<T, C> {
        columns.add(PseudoColumn(ctx.table, expression, alias))
        return this
    }

    override fun build() {
        ctx.mainClause = SelectPrintTask(ctx.optionMap, columns, ctx.table).print()
    }

}