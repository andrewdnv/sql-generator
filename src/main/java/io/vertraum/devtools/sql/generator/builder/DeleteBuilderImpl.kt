package io.vertraum.devtools.sql.generator.builder

import io.vertraum.devtools.sql.generator.builder.api.DeleteBuilder
import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.context.StmtContext

class DeleteBuilderImpl<T : ConditionBuilder>(override val ctx: StmtContext) : DeleteBuilder<T> {

    override fun build() {
        // TODO: implement
    }

}