package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder

interface CanGenerateSql<CB : ConditionBuilder<CB>> : ShouldFillContext<CB> {
    fun generateSql(): String = fillContext().run { ctx.sql() }
}