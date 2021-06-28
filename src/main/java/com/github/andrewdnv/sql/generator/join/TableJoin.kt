package com.github.andrewdnv.sql.generator.join

import com.github.andrewdnv.sql.generator.table.TableColumn

class TableJoin(
    val firstColumn: TableColumn,
    val secondColumn: TableColumn,
    val joinType: JoinType
)