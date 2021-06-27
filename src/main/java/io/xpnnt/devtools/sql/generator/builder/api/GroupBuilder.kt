package io.xpnnt.devtools.sql.generator.builder.api

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder

interface GroupBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB>, CanChooseColumns<GroupBuilder<CB>>, CanHaveConditions<CB>, CanPrecedeOrder<CB>