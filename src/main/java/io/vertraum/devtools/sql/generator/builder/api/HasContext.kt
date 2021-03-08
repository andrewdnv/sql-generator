package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.context.Context

interface HasContext {
    val ctx: Context

    fun fillContext()
}

typealias ShouldFillContext = HasContext