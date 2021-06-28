package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.order.OrderDirection
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

interface OrderBuilder<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : ClauseBuilder<TF, CB> {

    fun column(column: Column, direction: OrderDirection = OrderDirection.ASC): OrderBuilder<TF, CB>

}