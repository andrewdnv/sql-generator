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

    @Test
    fun testGenerateInsertStatement() {
        val expected = "INSERT " +
            "INTO user (user_id, first_name, last_name, city, age) " +
            "VALUES (:userId, :firstName, :lastName, :city, :age)"
        val actual = SqlGenerator.of(UserTableFactory)
            .insert()
            .allColumns()
            .generateSql()
        assertEquals(expected, actual)
    }

    @Test
    fun testGenerateUpdateStatement() {
        val expected = "UPDATE user " +
            "SET first_name = :firstName, last_name = :lastName, city = :city, age = :age " +
            "WHERE (user_id = :userId)"
        val actual = SqlGenerator.of(UserTableFactory)
            .update()
            .columns(UserTable.firstName, UserTable.lastName, UserTable.city, UserTable.age)
            .where()
            .userIdIsEqual()
            .generateSql()
        assertEquals(expected, actual)
    }

    @Test
    fun testGenerateDeleteStatement() {
        val expected = "DELETE FROM user " +
            "WHERE (user_id = :userId)"
        val actual = SqlGenerator.of(UserTableFactory)
            .delete()
            .where()
            .userIdIsEqual()
            .generateSql()
        assertEquals(expected, actual)
    }

}