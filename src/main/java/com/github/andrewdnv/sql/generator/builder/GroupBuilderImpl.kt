package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.api.GroupBuilder
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.task.print.GroupPrintTask

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