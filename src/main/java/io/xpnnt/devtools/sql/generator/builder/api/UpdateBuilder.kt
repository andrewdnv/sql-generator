package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder

interface UpdateBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB>, CanChooseColumns<UpdateBuilder<CB>>, CanHaveConditions<CB>