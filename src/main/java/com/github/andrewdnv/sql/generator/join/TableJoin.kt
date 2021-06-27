package com.github.andrewdnv.sql.generator.join

import com.github.andrewdnv.sql.generator.table.Column

class TableJoin(
    val firstColumn: Column,
    val secondColumn: Column,
    val joinType: JoinType
)