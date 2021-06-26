package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.option.ConditionOption
import io.xpnnt.devtools.sql.generator.context.option.OptionName
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface CanHaveConditions<T : Table, C : ConditionBuilder<T, C>> : ShouldFillContext<T, C> {
    fun where(): C = ctx
        .also { it.optionMap.put(OptionName.CONDITION_TYPE, ConditionOption.WHERE.value) }
        .conditionBuilder
        .also { fillContext() }

    fun having(): C = ctx
        .also { it.optionMap.put(OptionName.CONDITION_TYPE, ConditionOption.HAVING.value) }
        .conditionBuilder
        .also { fillContext() }
}