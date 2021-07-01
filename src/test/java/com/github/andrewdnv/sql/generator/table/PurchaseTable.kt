package com.github.andrewdnv.sql.generator.table

import com.github.andrewdnv.sql.generator.table.spi.SimpleTable

object PurchaseTable : SimpleTable(
    name = "purchase",
    alias = "purchase"
) {

    val purchaseId = column(name = "purchase_id", alias = "purchase_id", paramName = "purchaseId")

    val userId = column(name = "user_id", alias = "user_id", paramName = "userId")

    val productId = column(name = "product_id", alias = "product_id", paramName = "productId")

    val quantity = column(name = "quantity", alias = "quantity", paramName = "quantity")

    override fun allColumns(): List<Column> {
        return listOf(purchaseId, userId, productId, quantity)
    }

}