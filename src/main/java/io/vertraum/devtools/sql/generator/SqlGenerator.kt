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

class SqlGenerator<T : ConditionBuilder> private constructor(val ctx: StmtContext) {

    companion object {
        fun <T : ConditionBuilder> of(table: Table<T>) = SqlGenerator<T>(StmtContext(table))
    }

    fun select(): SelectBuilder<T> = SelectBuilderImpl(ctx)

    fun insert(): InsertBuilder = InsertBuilderImpl(ctx)

    fun update(): UpdateBuilder<T> = UpdateBuilderImpl(ctx)

    fun delete(): DeleteBuilder<T> = DeleteBuilderImpl(ctx)

}