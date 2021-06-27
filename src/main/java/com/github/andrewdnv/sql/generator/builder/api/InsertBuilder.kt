package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder

interface InsertBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB>, CanChooseColumns<InsertBuilder<CB>>