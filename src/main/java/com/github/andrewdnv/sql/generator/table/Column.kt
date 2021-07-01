package com.github.andrewdnv.sql.generator.table

import com.github.andrewdnv.sql.generator.table.spi.SimpleTable

sealed class Column(
    val table: SimpleTable? = null,
    val name: String? = null,
    val alias: String,
    val paramName: String? = null
)

class TableColumn(
    table: SimpleTable,
    name: String,
    alias: String,
    paramName: String
) : Column(table, name, alias, paramName)

class PseudoColumn(
    table: SimpleTable?,
    val expression: String,
    alias: String
) : Column(table = table, alias = alias)