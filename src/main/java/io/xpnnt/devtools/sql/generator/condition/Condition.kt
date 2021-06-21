package io.xpnnt.devtools.sql.generator.condition

import io.xpnnt.devtools.sql.generator.table.Column

sealed class Condition

class SimpleCondition(
    val column: Column,
    val operator: ComparisonOperator,
    val ignoreCase: Boolean = false
) : Condition()

class CustomCondition(
    val column: Column? = null,
    val expression: String
) : Condition()

class GroupedCondition(
    val conditions: List<Condition>,
    val connector: ComparisonConnector = ComparisonConnector.AND
)