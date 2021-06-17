package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.UpdateBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.spi.Table

class UpdateBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: SqlContext<T, C>) : UpdateBuilder<T, C> {

    override fun column(column: Column): UpdateBuilder<T, C> {
        TODO("Not yet implemented")
    }

    override fun columns(vararg columns: Column): UpdateBuilder<T, C> {
        TODO("Not yet implemented")
    }

    override fun allColumns(): UpdateBuilder<T, C> {
        TODO("Not yet implemented")
    }

    override fun build() {
        // TODO: implement
    }

}