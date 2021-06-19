package io.xpnnt.devtools.sql.generator.table

import io.xpnnt.devtools.sql.generator.table.spi.Table

sealed class Column(
    val table: Table,
    val alias: String,
    val paramName: String
)

class TableColumn(
    table: Table,
    val name: String,
    alias: String,
    paramName: String
) : Column(table, alias, paramName)

class PseudoColumn(
    table: Table,
    val expression: String,
    alias: String,
    paramName: String
) : Column(table, alias, paramName)