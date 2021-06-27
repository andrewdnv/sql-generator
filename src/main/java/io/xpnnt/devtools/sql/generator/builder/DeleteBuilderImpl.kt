package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.DeleteBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.task.print.DeletePrintTask

class DeleteBuilderImpl<CB : ConditionBuilder<CB>>(override val ctx: SqlContext<CB>) : DeleteBuilder<CB> {

    override fun build() {
        ctx.mainClause = DeletePrintTask(ctx.optionMap, ctx.table).print()
    }

}