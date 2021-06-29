package com.github.andrewdnv.sql.generator.table

import com.github.andrewdnv.sql.generator.table.spi.SimpleTable

object ProductTable : SimpleTable(
    name = "product",
    alias = "prod"
) {

    val productId = column(name = "product_id", alias = "product_id", paramName = "productId")

    val productName = column(name = "name", alias = "name", paramName = "name")

    val cost = column(name = "cost", alias = "cost", paramName = "cost")

    override fun allColumns(): List<Column> {
        return listOf(productId, productName, cost)
    }

}