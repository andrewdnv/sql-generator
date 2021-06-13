package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.table.spi.Table

interface AdditionalClauseBuilder<T : Table, C : ConditionBuilder<T, C>> : StmtBuilder<T, C>