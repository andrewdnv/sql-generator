package io.vertraum.devtools.sql.generator

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.context.StmtContext
import io.vertraum.devtools.sql.generator.table.spi.Table

class SqlGenerator private constructor(val ctx: StmtContext) {

    companion object {
        fun of(table : Table<out ConditionBuilder>) = SqlGenerator(StmtContext(table))
    }

    // TODO: implement

}