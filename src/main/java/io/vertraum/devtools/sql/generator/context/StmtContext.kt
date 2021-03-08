package io.vertraum.devtools.sql.generator.context

import io.vertraum.devtools.sql.generator.table.spi.Table

class StmtContext<T : Table>(val table: T) {
    // TODO: implement
}

typealias Context<T> = StmtContext<T>