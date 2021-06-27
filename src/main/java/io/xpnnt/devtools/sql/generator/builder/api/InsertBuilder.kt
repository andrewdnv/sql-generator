package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder

interface InsertBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB>, CanChooseColumns<InsertBuilder<CB>>