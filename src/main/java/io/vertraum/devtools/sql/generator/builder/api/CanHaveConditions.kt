package io.vertraum.devtools.sql.generator.builder.api

import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.context.Context
import io.vertraum.devtools.sql.generator.table.spi.Table

interface CanHaveConditions<T : Table, C : ConditionBuilder<T, C>> : ShouldFillContext {
    fun where(conditionFactory: (ctx: Context) -> C) = conditionFactory(ctx).also { fillContext() }
}