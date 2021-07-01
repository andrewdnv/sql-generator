package com.github.andrewdnv.sql.generator

import com.github.andrewdnv.sql.generator.table.UserTable
import com.github.andrewdnv.sql.generator.table.UserTableFactory
import org.junit.Test
import kotlin.test.assertEquals

class SqlGeneratorTest {

    @Test
    fun testGenerateSelectStatement() {
        val expected = "SELECT user_id, first_name, last_name, city, age " +
            "FROM user " +
            "WHERE ((first_name LIKE :firstName) OR (last_name LIKE :lastName)) " +
            "AND (age = :age) " +
            "AND (city NOT IN (:city)) " +
            "ORDER BY first_name ASC"
        val actual = SqlGenerator.of(UserTableFactory)
            .select()
            .allColumns()
            .where()
            .firstNameOrLastNameStartsWith()
            .ageIsEqual()
            .cityIsNotIn()
            .orderBy()
            .column(UserTable.firstName)
            .generateSql()
        assertEquals(expected, actual)
    }

}