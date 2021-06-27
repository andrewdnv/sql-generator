package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder

interface DeleteBuilder<CB : ConditionBuilder<CB>> : ClauseBuilder<CB>, CanHaveConditions<CB>