package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.api.OrderBuilder
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.order.OrderDirection
import com.github.andrewdnv.sql.generator.order.OrderVector
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.task.print.OrderPrintTask

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