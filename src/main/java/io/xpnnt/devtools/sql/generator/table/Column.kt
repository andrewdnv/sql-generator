package io.xpnnt.devtools.sql.generator.table

class Column(
    val name: String,
    val alias: String,
    val paramName: String = name
)