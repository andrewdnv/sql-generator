package com.github.andrewdnv.sql.generator.table

import com.github.andrewdnv.sql.generator.table.spi.SimpleTable

object UserTable : SimpleTable(
    name = "user",
    alias = "u"
) {

    val userId = column(name = "user_id", alias = "user_id", paramName = "userId")

    val firstName = column(name = "first_name", alias = "first_name", paramName = "firstName")

    val lastName = column(name = "last_name", alias = "last_name", paramName = "lastName")

    val city = column(name = "city", alias = "city", paramName = "city")

    val age = column(name = "age", alias = "age", paramName = "age")

    override fun allColumns(): List<Column> {
        return listOf(userId, firstName, lastName, city, age)
    }

}