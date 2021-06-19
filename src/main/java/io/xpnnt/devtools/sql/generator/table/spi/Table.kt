package io.xpnnt.devtools.sql.generator.table.spi

import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.TableColumn

interface Table {

    val name: String

    val alias: String

    fun allColumns(): List<Column>

    fun column(name: String, alias: String, paramName: String = name) =
        TableColumn(this, name, alias, paramName)

}