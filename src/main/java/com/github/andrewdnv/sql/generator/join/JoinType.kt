package com.github.andrewdnv.sql.generator.join

enum class JoinType(val value: String) {
    INNER("join"),
    LEFT("left join"),
    RIGHT("right join"),
    FULL("full outer join")
}