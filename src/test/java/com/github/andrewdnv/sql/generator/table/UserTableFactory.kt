package com.github.andrewdnv.sql.generator.table

import com.github.andrewdnv.sql.generator.builder.UserConditionBuilder
import com.github.andrewdnv.sql.generator.condition.ConditionType
import com.github.andrewdnv.sql.generator.context.SqlContext
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

class UserTableFactory : TableFactory<UserTableFactory, UserConditionBuilder> {

    override fun table() = UserTable

    override fun conditionBuilder(ctx: SqlContext<UserTableFactory, UserConditionBuilder>, type: ConditionType) =
        UserConditionBuilder(ctx, type)

}