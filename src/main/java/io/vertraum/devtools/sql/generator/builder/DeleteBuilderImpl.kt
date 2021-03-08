package io.vertraum.devtools.sql.generator.builder

import io.vertraum.devtools.sql.generator.builder.api.DeleteBuilder
import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.context.StmtContext
import io.vertraum.devtools.sql.generator.table.spi.Table

class DeleteBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: StmtContext) : DeleteBuilder<T, C> {

    override fun build() {
        // TODO: implement
    }

}