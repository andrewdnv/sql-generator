package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.condition.ConditionType
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

interface CanPrecedeWhereConditions<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : ShouldFillContext<TF, CB> {
    fun where(): CB = ctx
        .conditionBuilder(ConditionType.WHERE)
        .also { fillContext() }

    fun conditionBuilder() = where()
}