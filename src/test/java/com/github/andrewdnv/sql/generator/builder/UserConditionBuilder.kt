package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.condition.*
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.UserTable
import com.github.andrewdnv.sql.generator.table.UserTableFactory

class UserConditionBuilder(
    override val ctx: SqlContext<UserTableFactory, UserConditionBuilder>,
    override val type: ConditionType
) : ConditionBuilder<UserTableFactory, UserConditionBuilder> {

    override val conditions = mutableListOf<Condition>()

    fun firstNameOrLastNameStartsWith(): UserConditionBuilder {
        val firstNameCondition = SimpleCondition(UserTable.firstName, ComparisonOperator.LIKE)
        val lastNameCondition = SimpleCondition(UserTable.lastName, ComparisonOperator.LIKE)
        conditions.add(GroupedCondition(listOf(firstNameCondition, lastNameCondition), ComparisonConnector.OR))
        return this
    }

    fun ageIsEqual(): UserConditionBuilder {
        conditions.add(SimpleCondition(UserTable.age, ComparisonOperator.EQUAL))
        return this
    }

    fun cityIsNotIn(): UserConditionBuilder {
        conditions.add(SimpleCondition(UserTable.city, ComparisonOperator.NOT_IN))
        return this
    }

}