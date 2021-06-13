package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface StmtBuilder<T : Table, C : ConditionBuilder<T, C>> : CanGenerateSql<T, C> {
    fun build()

    override fun fillContext() = build()
}