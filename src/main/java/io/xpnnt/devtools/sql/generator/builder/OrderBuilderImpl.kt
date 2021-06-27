package io.xpnnt.devtools.sql.generator.builder

import io.xpnnt.devtools.sql.generator.builder.api.OrderBuilder
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.SqlContext
import io.xpnnt.devtools.sql.generator.order.OrderDirection
import io.xpnnt.devtools.sql.generator.order.OrderVector
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.task.print.OrderPrintTask

class OrderBuilderImpl<CB : ConditionBuilder<CB>>(override val ctx: SqlContext<CB>) : OrderBuilder<CB> {

    private val orderVectors = mutableListOf<OrderVector>()

    override fun column(column: Column, direction: OrderDirection): OrderBuilder<CB> {
        orderVectors.add(OrderVector(column, direction))
        return this
    }

    override fun build() {
        ctx.orderClause = OrderPrintTask(ctx.optionMap, orderVectors).print()
    }

}