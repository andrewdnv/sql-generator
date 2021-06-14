package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.SelectBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.StmtContext
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.spi.Table

class SelectBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: StmtContext<T, C>) : SelectBuilder<T, C> {

    override fun column(column: Column): SelectBuilder<T, C> {
        TODO("Not yet implemented")
    }

    override fun columns(vararg columns: Column): SelectBuilder<T, C> {
        TODO("Not yet implemented")
    }

    override fun allColumns(): SelectBuilder<T, C> {
        TODO("Not yet implemented")
    }

    override fun expression(expression: String, alias: String): T {
        TODO("Not yet implemented")
    }

    override fun build() {
        // TODO: implement
    }

}