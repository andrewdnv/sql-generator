package io.xpnnt.devtools.sql.generator.context

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.table.spi.Table

class SqlContext<T : Table, C : ConditionBuilder<T, C>>(val table: T) {

    lateinit var conditionBuilder: C

    // TODO: implement

}

typealias Context<T, C> = SqlContext<T, C>