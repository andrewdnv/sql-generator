package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.InsertBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.StmtContext
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.spi.Table

class InsertBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: StmtContext<T, C>) : InsertBuilder<T, C> {

    override fun column(column: Column): InsertBuilder<T, C> {
        TODO("Not yet implemented")
    }

    override fun columns(vararg columns: Column): InsertBuilder<T, C> {
        TODO("Not yet implemented")
    }

    override fun allColumns(): InsertBuilder<T, C> {
        TODO("Not yet implemented")
    }

    override fun build() {
        // TODO: implement
    }

}