package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.GroupBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.task.print.GroupPrintTask

class GroupBuilderImpl<CB : ConditionBuilder<CB>>(override val ctx: SqlContext<CB>) : GroupBuilder<CB> {

    override val columns = mutableListOf<Column>()

    override fun column(column: Column): GroupBuilder<CB> {
        columns.add(column)
        return this
    }

    override fun columns(vararg columns: Column): GroupBuilder<CB> {
        this.columns.addAll(columns)
        return this
    }

    override fun allColumns(): GroupBuilder<CB> {
        columns.clear()
        columns.addAll(ctx.table.allColumns())
        return this
    }

    override fun build() {
        ctx.groupClause = GroupPrintTask(ctx.optionMap, columns).print()
    }

}