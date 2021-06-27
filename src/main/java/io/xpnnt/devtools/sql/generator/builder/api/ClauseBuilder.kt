package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder

interface ClauseBuilder<CB : ConditionBuilder<CB>> : CanGenerateSql<CB> {
    fun build()

    override fun fillContext() = build()
}