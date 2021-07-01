package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.api.GroupBuilder
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.spi.TableFactory
import com.github.andrewdnv.sql.generator.task.print.GroupPrintTask

class GroupBuilderImpl<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>>(override val ctx: SqlContext<TF, CB>) : GroupBuilder<TF, CB> {

    override val columns = mutableListOf<Column>()

    override fun column(column: Column): GroupBuilder<TF, CB> {
        columns.add(column)
        return this
    }

    override fun columns(vararg columns: Column): GroupBuilder<TF, CB> {
        this.columns.addAll(columns)
        return this
    }

    override fun allColumns(): GroupBuilder<TF, CB> {
        columns.clear()
        columns.addAll(ctx.table().allColumns())
        return this
    }

    override fun build() {
        ctx.groupClause = GroupPrintTask(ctx.optionMap, columns).print()
    }

}