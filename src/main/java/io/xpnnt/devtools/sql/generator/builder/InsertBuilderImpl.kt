package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.InsertBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.spi.Table

class InsertBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: SqlContext<T, C>) : InsertBuilder<T, C> {

    private val columns = mutableListOf<Column>()

    override fun column(column: Column): InsertBuilder<T, C> {
        columns.add(column)
        return this
    }

    override fun columns(vararg columns: Column): InsertBuilder<T, C> {
        this.columns.addAll(columns)
        return this
    }

    override fun allColumns(): InsertBuilder<T, C> {
        columns.clear()
        columns.addAll(ctx.table.allColumns())
        return this
    }

    override fun build() {
        // TODO: implement
    }

}