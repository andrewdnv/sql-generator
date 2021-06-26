package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.GroupBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.spi.Table
import io.xpnnt.devtools.sql.generator.task.print.GroupPrintTask

class GroupBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: SqlContext<T, C>) : GroupBuilder<T, C> {

    override val columns = mutableListOf<Column>()

    override fun column(column: Column): GroupBuilder<T, C> {
        columns.add(column)
        return this
    }

    override fun columns(vararg columns: Column): GroupBuilder<T, C> {
        this.columns.addAll(columns)
        return this
    }

    override fun allColumns(): GroupBuilder<T, C> {
        columns.clear()
        columns.addAll(ctx.table.allColumns())
        return this
    }

    override fun build() {
        ctx.groupClause = GroupPrintTask(ctx.optionMap, columns).print()
    }

}