package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.OrderBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.order.OrderDirection
import io.xpnnt.devtools.sql.generator.order.OrderVector
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.spi.Table
import io.xpnnt.devtools.sql.generator.task.print.OrderPrintTask

class OrderBuilderImpl<T : Table, C : ConditionBuilder<T, C>>(override val ctx: SqlContext<T, C>) : OrderBuilder<T, C> {

    private val orderVectors = mutableListOf<OrderVector>()

    override fun column(column: Column, direction: OrderDirection): OrderBuilder<T, C> {
        orderVectors.add(OrderVector(column, direction))
        return this
    }

    override fun build() {
        ctx.orderClause = OrderPrintTask(ctx.optionMap, orderVectors).print()
    }

}