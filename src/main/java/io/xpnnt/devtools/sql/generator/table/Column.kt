package io.xpnnt.devtools.sql.generator.table

import io.xpnnt.devtools.sql.generator.table.spi.Table

sealed class Column(
    val alias: String,
    val paramName: String
)

class TableColumn(
    val table: Table,
    val name: String,
    alias: String,
    paramName: String
) : Column(alias, paramName)

class PseudoColumn(
    val expression: String,
    alias: String,
    paramName: String
) : Column(alias, paramName)