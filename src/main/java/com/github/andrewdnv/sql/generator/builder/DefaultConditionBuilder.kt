package com.github.andrewdnv.sql.generator.builder

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.condition.ComparisonOperator
import com.github.andrewdnv.sql.generator.condition.Condition
import com.github.andrewdnv.sql.generator.condition.ConditionType
import com.github.andrewdnv.sql.generator.condition.SimpleCondition
import com.github.andrewdnv.sql.generator.context.Context
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

class DefaultConditionBuilder<T : TableFactory<T, DefaultConditionBuilder<T>>>(
    override val ctx: Context<T, DefaultConditionBuilder<T>>,
    override val type: ConditionType
) : ConditionBuilder<T, DefaultConditionBuilder<T>> {

    override val conditions: MutableList<Condition> = mutableListOf()

    fun columnIsEqual(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.EQUAL))
        return this
    }

    fun columnIsEqualIgnoreCase(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.EQUAL, ignoreCase = true))
        return this
    }

    fun columnIsNotEqual(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.NOT_EQUAL))
        return this
    }

    fun columnIsGreater(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.GREATER))
        return this
    }

    fun columnIsLess(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.LESS))
        return this
    }

    fun columnIsGreaterOrEqual(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.GREATER_OR_EQUAL))
        return this
    }

    fun columnIsLessOrEqual(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.LESS_OR_EQUAL))
        return this
    }

    fun columnIsLike(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.LIKE))
        return this
    }

    fun columnIsLikeIgnoreCase(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.LIKE, ignoreCase = true))
        return this
    }

    fun columnIsNotLike(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.NOT_LIKE))
        return this
    }

    fun columnIsIn(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.IN))
        return this
    }

    fun columnIsNotIn(column: Column): DefaultConditionBuilder<T> {
        conditions.add(SimpleCondition(column, ComparisonOperator.NOT_IN))
        return this
    }

}