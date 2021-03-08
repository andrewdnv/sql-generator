package io.vertraum.devtools.sql.generator.builder.api

interface StmtBuilder : CanGenerateSql {
    fun build()

    override fun fillContext() = build()
}