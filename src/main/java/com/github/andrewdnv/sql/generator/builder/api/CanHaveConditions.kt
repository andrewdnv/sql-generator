package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.option.ConditionOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

interface CanHaveConditions<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : ShouldFillContext<TF, CB> {
    fun where(): CB = ctx
        .also { it.optionMap.put(OptionName.CONDITION_TYPE, ConditionOption.WHERE.value) }
        .conditionBuilder()
        .also { fillContext() }

    fun having(): CB = ctx
        .also { it.optionMap.put(OptionName.CONDITION_TYPE, ConditionOption.HAVING.value) }
        .conditionBuilder()
        .also { fillContext() }
}