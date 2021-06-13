package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.DeleteBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.StmtContext
import io.xpnnt.devtools.sql.generator.table.spi.Table

class DeleteBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: StmtContext<T, C>) : DeleteBuilder<T, C> {

    override fun build() {
        // TODO: implement
    }

}