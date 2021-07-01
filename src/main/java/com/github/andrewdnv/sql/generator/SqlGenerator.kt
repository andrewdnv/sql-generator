package com.github.andrewdnv.sql.generator

import com.github.andrewdnv.sql.generator.builder.*
import com.github.andrewdnv.sql.generator.builder.api.*
import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

class SqlGenerator<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> private constructor(val ctx: SqlContext<TF, CB>) {

    companion object {
        fun <TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> of(tableFactory: TableFactory<TF, CB>): SqlGenerator<TF, CB> {
            val ctx = SqlContext(tableFactory)
            return SqlGenerator(ctx)
        }
    }

    fun select(): SelectBuilder<TF, CB> = SelectBuilderImpl(ctx)

    fun insert(): InsertBuilder<TF, CB> = InsertBuilderImpl(ctx)

    fun update(): UpdateBuilder<TF, CB> = UpdateBuilderImpl(ctx)

    fun delete(): DeleteBuilder<TF, CB> = DeleteBuilderImpl(ctx)

}