package com.github.andrewdnv.sql.generator.join

import com.github.andrewdnv.sql.generator.table.TableColumn
import com.github.andrewdnv.sql.generator.table.spi.PseudoTable

class TableJoiner private constructor() {

    private var table: PseudoTable = PseudoTable()

    companion object {
        fun newInstance() = TableJoiner()
    }

    fun innerJoin(firstColumn: TableColumn, secondColumn: TableColumn): TableJoiner {
        table.addTableJoin(TableJoin(firstColumn, secondColumn, JoinType.INNER))
        return this
    }

    fun join(firstColumn: TableColumn, secondColumn: TableColumn): TableJoiner = innerJoin(firstColumn, secondColumn)

    fun leftJoin(firstColumn: TableColumn, secondColumn: TableColumn): TableJoiner {
        table.addTableJoin(TableJoin(firstColumn, secondColumn, JoinType.LEFT))
        return this
    }

    fun rightJoin(firstColumn: TableColumn, secondColumn: TableColumn): TableJoiner {
        table.addTableJoin(TableJoin(firstColumn, secondColumn, JoinType.RIGHT))
        return this
    }

    fun fullJoin(firstColumn: TableColumn, secondColumn: TableColumn): TableJoiner {
        table.addTableJoin(TableJoin(firstColumn, secondColumn, JoinType.FULL))
        return this
    }

    fun get() = table

}