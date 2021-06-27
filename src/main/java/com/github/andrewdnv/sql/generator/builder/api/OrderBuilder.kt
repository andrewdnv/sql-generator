package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.order.OrderDirection
import com.github.andrewdnv.sql.generator.table.Column

interface OrderBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB> {

    fun column(column: Column, direction: OrderDirection = OrderDirection.ASC): OrderBuilder<CB>

}