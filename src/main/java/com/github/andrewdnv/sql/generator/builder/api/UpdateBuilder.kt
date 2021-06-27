package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder

interface UpdateBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB>, CanChooseColumns<UpdateBuilder<CB>>, CanHaveConditions<CB>