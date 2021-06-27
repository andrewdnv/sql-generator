package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.UpdateBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.task.print.UpdatePrintTask

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