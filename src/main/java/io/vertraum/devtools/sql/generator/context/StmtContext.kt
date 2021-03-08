package io.vertraum.devtools.sql.generator.context

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.table.spi.Table

class StmtContext(val table: Table<out ConditionBuilder>) {

    val conditionBuilder: ConditionBuilder by lazy { table.conditionBuilder(this) }

    // TODO: implement

}

typealias Context = StmtContext