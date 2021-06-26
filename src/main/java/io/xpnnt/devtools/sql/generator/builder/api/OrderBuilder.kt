package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.order.OrderDirection
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface OrderBuilder<T : Table, C : ConditionBuilder<T, C>> : ClauseBuilder<T, C> {

    fun column(column: Column, direction: OrderDirection = OrderDirection.ASC): OrderBuilder<T, C>

}