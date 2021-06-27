package com.github.andrewdnv.sql.generator.table

import com.github.andrewdnv.sql.generator.table.spi.Table

sealed class Column(
    val table: Table,
    val name: String? = null,
    val alias: String,
    val paramName: String? = null
)

class TableColumn(
    table: Table,
    name: String,
    alias: String,
    paramName: String
) : Column(table, name, alias, paramName)

class PseudoColumn(
    table: Table,
    val expression: String,
    alias: String
) : Column(table = table, alias = alias)