package com.github.andrewdnv.sql.generator.join

import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.spi.PseudoTable

class TableJoiner private constructor() {

    private var table: PseudoTable? = null
        get() {
            if (field == null) {
                field = PseudoTable()
            }
            return field
        }

    companion object {
        fun newInstance() = TableJoiner()
    }

    fun innerJoin(firstColumn: Column, secondColumn: Column): TableJoiner {
        table!!.addTableJoin(TableJoin(firstColumn, secondColumn, JoinType.INNER))
        return this
    }

    fun join(firstColumn: Column, secondColumn: Column): TableJoiner = innerJoin(firstColumn, secondColumn)

    fun left(firstColumn: Column, secondColumn: Column): TableJoiner {
        table!!.addTableJoin(TableJoin(firstColumn, secondColumn, JoinType.LEFT))
        return this
    }

    fun rightJoin(firstColumn: Column, secondColumn: Column): TableJoiner {
        table!!.addTableJoin(TableJoin(firstColumn, secondColumn, JoinType.RIGHT))
        return this
    }

    fun fullJoin(firstColumn: Column, secondColumn: Column): TableJoiner {
        table!!.addTableJoin(TableJoin(firstColumn, secondColumn, JoinType.FULL))
        return this
    }

    fun get() = table

}