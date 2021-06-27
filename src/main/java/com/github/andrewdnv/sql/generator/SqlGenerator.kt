package com.github.andrewdnv.sql.generator

import com.github.andrewdnv.sql.generator.builder.*
import com.github.andrewdnv.sql.generator.builder.api.*
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.spi.Table
import kotlin.reflect.KClass

class SqlGenerator<CB : ConditionBuilder<CB>> private constructor(val ctx: SqlContext<CB>) {

    companion object {
        fun <CB : ConditionBuilder<CB>> of(table: Table, conditionBuilderKClass: KClass<CB>): SqlGenerator<CB> {
            return of(table, conditionBuilderKClass.constructors.first()::call)
        }

        fun <CB : ConditionBuilder<CB>> of(table: Table, conditionBuilderFactory: (ctx: SqlContext<CB>) -> CB): SqlGenerator<CB> {
            val ctx = SqlContext<CB>(table)
            ctx.conditionBuilder = conditionBuilderFactory(ctx)
            return SqlGenerator(ctx)
        }
    }

    fun select(): SelectBuilder<CB> = SelectBuilderImpl(ctx)

    fun insert(): InsertBuilder<CB> = InsertBuilderImpl(ctx)

    fun update(): UpdateBuilder<CB> = UpdateBuilderImpl(ctx)

    fun delete(): DeleteBuilder<CB> = DeleteBuilderImpl(ctx)

}