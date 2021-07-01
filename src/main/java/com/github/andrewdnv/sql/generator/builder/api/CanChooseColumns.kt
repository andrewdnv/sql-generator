package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.table.Column

interface CanChooseColumns<T : CanChooseColumns<T>> {

    val columns: MutableList<Column>

    fun column(column: Column): T

    fun columns(vararg columns: Column): T

    fun allColumns(): T

}