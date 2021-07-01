package com.github.andrewdnv.sql.generator.condition

enum class ComparisonOperator(val value: String) {
    EQUAL("="),
    NOT_EQUAL("<>"),
    GREATER(">"),
    LESS("<"),
    GREATER_OR_EQUAL(">="),
    LESS_OR_EQUAL("<="),
    LIKE("like"),
    IN("in"),
    NOT_LIKE("not like"),
    NOT_IN("not in")
}