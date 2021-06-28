package com.github.andrewdnv.sql.generator.builder.api

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

interface InsertBuilder<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>> : ClauseBuilder<TF, CB>, CanChooseColumns<InsertBuilder<TF, CB>>