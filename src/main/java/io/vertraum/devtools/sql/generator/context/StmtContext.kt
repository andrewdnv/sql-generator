package io.vertraum.devtools.sql.generator.context

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.table.spi.Table

class StmtContext(val table: Table<out ConditionBuilder>) {
    // TODO: implement
}

typealias Context = StmtContext