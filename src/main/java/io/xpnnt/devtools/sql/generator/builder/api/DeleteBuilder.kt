package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder

interface DeleteBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB>, CanHaveConditions<CB>