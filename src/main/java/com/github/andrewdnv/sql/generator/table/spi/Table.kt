package com.github.andrewdnv.sql.generator.table.spi

import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.TableColumn

interface Table {

    val name: String

    val alias: String

    fun allColumns(): List<Column>

    fun column(name: String, alias: String, paramName: String = name) =
        TableColumn(this, name, alias, paramName)

}