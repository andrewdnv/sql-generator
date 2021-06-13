package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.SelectBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.StmtContext
import io.xpnnt.devtools.sql.generator.table.spi.Table

class SelectBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: StmtContext<T, C>) : SelectBuilder<T, C> {

    override fun build() {
        // TODO: implement
    }

}