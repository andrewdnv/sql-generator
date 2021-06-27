package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.AliasOption
import com.github.andrewdnv.sql.generator.context.option.CaseOption
import com.github.andrewdnv.sql.generator.context.option.ChoiceOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.table.spi.SimpleTable

class SimpleTablePrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val table: SimpleTable
) : PrintTask {

    override fun print(): String {
        return tableNameExpression()
    }

    private fun tableNameExpression(): String {
        val useTableAliasValue = optionMap[OptionName.USE_TABLE_ALIAS]
        return if (useTableAliasValue == ChoiceOption.YES.value) {
            "${tableName()} ${tableAliasExpression()}"
        } else {
            tableName()
        }
    }

    private fun tableName(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            table.name!!.toUpperCase()
        } else {
            table.name!!.toLowerCase()
        }
    }

    private fun tableAliasExpression(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        val tableAliasCased = if (identifierCaseValue == CaseOption.UPPER.value) {
            table.alias!!.toUpperCase()
        } else {
            table.alias!!.toLowerCase()
        }
        return "${tableAliasWord()}$tableAliasCased"
    }

    private fun tableAliasWord(): String {
        val tableAliasWordValue = optionMap[OptionName.ALIAS_WORD]
        val tableAliasWord = if (tableAliasWordValue == AliasOption.NONE.value) {
            ""
        } else {
            "as "
        }
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            tableAliasWord.toLowerCase()
        } else {
            tableAliasWord.toUpperCase()
        }
    }

}