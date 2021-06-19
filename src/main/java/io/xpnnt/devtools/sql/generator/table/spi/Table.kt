package io.xpnnt.devtools.sql.generator.table.spi

import io.xpnnt.devtools.sql.generator.table.Column

interface Table {

    val name: String

    val alias: String

    fun allColumns(): List<Column>

}