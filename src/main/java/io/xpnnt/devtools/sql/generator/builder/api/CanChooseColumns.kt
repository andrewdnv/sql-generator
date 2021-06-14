package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.table.Column

interface CanChooseColumns<T : CanChooseColumns<T>> {

    fun column(column: Column): T

    fun columns(vararg columns: Column): T

    fun allColumns(): T

}