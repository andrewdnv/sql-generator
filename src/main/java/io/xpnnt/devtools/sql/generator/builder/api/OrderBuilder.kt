package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.order.OrderDirection
import io.xpnnt.devtools.sql.generator.table.Column

interface OrderBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB> {

    fun column(column: Column, direction: OrderDirection = OrderDirection.ASC): OrderBuilder<CB>

}