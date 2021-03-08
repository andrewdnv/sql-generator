package io.vertraum.devtools.sql.generator.builder

import io.vertraum.devtools.sql.generator.builder.api.SelectBuilder
import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.context.StmtContext

class SelectBuilderImpl<T : ConditionBuilder>(override val ctx: StmtContext) : SelectBuilder<T> {

    override fun build() {
        // TODO: implement
    }

}