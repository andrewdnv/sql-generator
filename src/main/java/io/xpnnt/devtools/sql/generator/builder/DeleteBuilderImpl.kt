package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.DeleteBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.table.spi.Table
import io.xpnnt.devtools.sql.generator.task.print.DeletePrintTask

class DeleteBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: SqlContext<T, C>) : DeleteBuilder<T, C> {

    override fun build() {
        ctx.mainClause = DeletePrintTask(ctx.optionMap, ctx.table).print()
    }

}