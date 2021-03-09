package io.vertraum.devtools.sql.generator.context

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.table.spi.Table

class StmtContext<T : Table, C : ConditionBuilder<T, C>>(val table: T) {

    lateinit var conditionBuilder: C

    // TODO: implement

}

typealias Context<T, C> = StmtContext<T, C>