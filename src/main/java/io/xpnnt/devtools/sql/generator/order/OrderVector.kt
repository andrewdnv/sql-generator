package io.xpnnt.devtools.sql.generator.order

import io.xpnnt.devtools.sql.generator.table.Column

class OrderVector(
    val column: Column,
    val direction: OrderDirection
)