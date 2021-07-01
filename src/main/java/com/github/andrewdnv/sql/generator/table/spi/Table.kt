package com.github.andrewdnv.sql.generator.table.spi

import com.github.andrewdnv.sql.generator.join.TableJoin
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.TableColumn

sealed class Table(
    val name: String? = null,
    val alias: String? = null
) {
    abstract fun allColumns(): List<Column>
}

abstract class SimpleTable(
    name: String,
    alias: String
) : Table(name, alias) {
    fun column(name: String, alias: String = name, paramName: String = name) =
        TableColumn(this, name, alias, paramName)
}

class PseudoTable : Table() {

    val tableJoins: MutableList<TableJoin> = mutableListOf()

    fun addTableJoin(tableJoin: TableJoin) = tableJoins.add(tableJoin)

    override fun allColumns(): List<Column> {
        val joinedTables = LinkedHashSet<SimpleTable>()
        tableJoins.forEach {
            joinedTables.add(it.firstColumn.table!!)
            joinedTables.add(it.secondColumn.table!!)
        }
        return joinedTables.flatMap { it.allColumns() }
    }

}