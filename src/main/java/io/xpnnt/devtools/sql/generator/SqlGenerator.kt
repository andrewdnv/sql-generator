package io.xpnnt.devtools.sql.generator

import io.xpnnt.devtools.sql.generator.builder.DeleteBuilderImpl
import io.xpnnt.devtools.sql.generator.builder.InsertBuilderImpl
import io.xpnnt.devtools.sql.generator.builder.SelectBuilderImpl
import io.xpnnt.devtools.sql.generator.builder.UpdateBuilderImpl
import io.xpnnt.devtools.sql.generator.builder.api.*
import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.StmtContext
import io.xpnnt.devtools.sql.generator.table.spi.Table
import kotlin.reflect.KClass

class SqlGenerator<T : Table, C : ConditionBuilder<T, C>> private constructor(val ctx: StmtContext<T, C>) {

    companion object {
        fun <T : Table, C : ConditionBuilder<T, C>> of(table: T, conditionBuilderKClass: KClass<C>): SqlGenerator<T, C> {
            return of(table, conditionBuilderKClass.constructors.first()::call)
        }

        fun <T : Table, C : ConditionBuilder<T, C>> of(table: T, conditionBuilderFactory: (ctx: StmtContext<T, C>) -> C): SqlGenerator<T, C> {
            val ctx = StmtContext<T, C>(table)
            ctx.conditionBuilder = conditionBuilderFactory(ctx)
            return SqlGenerator<T, C>(ctx)
        }
    }

    fun select(): SelectBuilder<T, C> = SelectBuilderImpl(ctx)

    fun insert(): InsertBuilder<T, C> = InsertBuilderImpl(ctx)

    fun update(): UpdateBuilder<T, C> = UpdateBuilderImpl(ctx)

    fun delete(): DeleteBuilder<T, C> = DeleteBuilderImpl(ctx)

}