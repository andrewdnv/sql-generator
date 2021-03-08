package io.vertraum.devtools.sql.generator

import io.vertraum.devtools.sql.generator.builder.DeleteBuilderImpl
import io.vertraum.devtools.sql.generator.builder.InsertBuilderImpl
import io.vertraum.devtools.sql.generator.builder.SelectBuilderImpl
import io.vertraum.devtools.sql.generator.builder.UpdateBuilderImpl
import io.vertraum.devtools.sql.generator.builder.api.DeleteBuilder
import io.vertraum.devtools.sql.generator.builder.api.InsertBuilder
import io.vertraum.devtools.sql.generator.builder.api.SelectBuilder
import io.vertraum.devtools.sql.generator.builder.api.UpdateBuilder
import io.vertraum.devtools.sql.generator.builder.spi.ConditionBuilder
import io.vertraum.devtools.sql.generator.context.StmtContext
import io.vertraum.devtools.sql.generator.table.spi.Table

class SqlGenerator<T : Table, C : ConditionBuilder<T, C>> private constructor(val ctx: StmtContext<T>) {

    companion object {
        fun <T : Table, C : ConditionBuilder<T, C>> of(table: T) = SqlGenerator<T, C>(StmtContext(table))
    }

    fun select(): SelectBuilder<T, C> = SelectBuilderImpl(ctx)

    fun insert(): InsertBuilder = InsertBuilderImpl(ctx)

    fun update(): UpdateBuilder<T, C> = UpdateBuilderImpl(ctx)

    fun delete(): DeleteBuilder<T, C> = DeleteBuilderImpl(ctx)

}