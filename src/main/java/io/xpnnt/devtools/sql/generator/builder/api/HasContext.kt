package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.Context

interface HasContext<CB : ConditionBuilder<CB>> {
    val ctx: Context<CB>

    fun fillContext()
}

typealias ShouldFillContext<CB> = HasContext<CB>