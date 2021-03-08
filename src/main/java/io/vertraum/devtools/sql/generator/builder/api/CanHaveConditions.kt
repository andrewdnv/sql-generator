package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder

interface CanHaveConditions<T : ConditionBuilder> : ShouldFillContext {
    fun where(): ConditionBuilder = ctx.conditionBuilder.also { fillContext() }
}