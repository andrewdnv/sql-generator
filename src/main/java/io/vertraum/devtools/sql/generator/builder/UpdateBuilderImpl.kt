package io.vertraum.devtools.sql.generator.builder

import io.vertraum.devtools.sql.generator.builder.api.UpdateBuilder
import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.context.StmtContext

class UpdateBuilderImpl<T : ConditionBuilder>(override val ctx: StmtContext) : UpdateBuilder<T> {

    override fun build() {
        // TODO: implement
    }

}