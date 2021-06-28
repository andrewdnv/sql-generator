package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

interface DeleteBuilder<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : ClauseBuilder<TF, CB>, CanHaveConditions<TF, CB>