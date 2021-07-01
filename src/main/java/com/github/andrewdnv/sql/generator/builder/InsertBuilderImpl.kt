package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.api.InsertBuilder
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.spi.TableFactory
import com.github.andrewdnv.sql.generator.task.print.InsertPrintTask

class InsertBuilderImpl<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>>(override val ctx: SqlContext<TF, CB>) : InsertBuilder<TF, CB> {

    override val columns = mutableListOf<Column>()

    override fun column(column: Column): InsertBuilder<TF, CB> {
        columns.add(column)
        return this
    }

    override fun columns(vararg columns: Column): InsertBuilder<TF, CB> {
        this.columns.addAll(columns)
        return this
    }

    override fun allColumns(): InsertBuilder<TF, CB> {
        columns.clear()
        columns.addAll(ctx.table().allColumns())
        return this
    }

    override fun build() {
        ctx.mainClause = InsertPrintTask(ctx.optionMap, columns, ctx.table()).print()
    }

}