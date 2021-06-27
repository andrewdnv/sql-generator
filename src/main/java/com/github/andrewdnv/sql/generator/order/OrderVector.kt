package com.github.andrewdnv.sql.generator.order

import com.github.andrewdnv.sql.generator.table.Column

class OrderVector(
    val column: Column,
    val direction: OrderDirection
)