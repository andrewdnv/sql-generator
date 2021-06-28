package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.api.DeleteBuilder
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.spi.TableFactory
import com.github.andrewdnv.sql.generator.task.print.DeletePrintTask

class DeleteBuilderImpl<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>>(override val ctx: SqlContext<TF, CB>) : DeleteBuilder<TF, CB> {

    override fun build() {
        ctx.mainClause = DeletePrintTask(ctx.optionMap, ctx.table()).print()
    }

}