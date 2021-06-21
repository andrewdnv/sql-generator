package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.UpdateBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.spi.Table
import io.xpnnt.devtools.sql.generator.task.print.UpdatePrintTask

class UpdateBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: SqlContext<T, C>) : UpdateBuilder<T, C> {

    private val columns = mutableListOf<Column>()

    override fun column(column: Column): UpdateBuilder<T, C> {
        columns.add(column)
        return this
    }

    override fun columns(vararg columns: Column): UpdateBuilder<T, C> {
        this.columns.addAll(columns)
        return this
    }

    override fun allColumns(): UpdateBuilder<T, C> {
        columns.clear()
        columns.addAll(ctx.table.allColumns())
        return this
    }

    override fun build() {
        ctx.mainClause = UpdatePrintTask(ctx.optionMap, columns, ctx.table).print()
    }

}