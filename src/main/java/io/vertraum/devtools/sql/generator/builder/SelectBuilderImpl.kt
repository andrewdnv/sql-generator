package io.vertraum.devtools.sql.generator.builder

import io.vertraum.devtools.sql.generator.builder.api.SelectBuilder
import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.context.StmtContext
import io.vertraum.devtools.sql.generator.table.spi.Table

class SelectBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: StmtContext) : SelectBuilder<T, C> {

    override fun build() {
        // TODO: implement
    }

}