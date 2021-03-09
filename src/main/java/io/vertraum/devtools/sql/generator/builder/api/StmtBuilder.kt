package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.table.spi.Table

interface StmtBuilder<T : Table, C : ConditionBuilder<T, C>> : CanGenerateSql<T, C> {
    fun build()

    override fun fillContext() = build()
}