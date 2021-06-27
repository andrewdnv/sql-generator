package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.api.DeleteBuilder
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.task.print.DeletePrintTask

class DeleteBuilderImpl<CB : ConditionBuilder<CB>>(override val ctx: SqlContext<CB>) : DeleteBuilder<CB> {

    override fun build() {
        ctx.mainClause = DeletePrintTask(ctx.optionMap, ctx.table).print()
    }

}