package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder

interface GroupBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB>, CanChooseColumns<GroupBuilder<CB>>, CanHaveConditions<CB>, CanPrecedeOrder<CB>