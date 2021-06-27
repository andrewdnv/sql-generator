package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.*
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.spi.Table

class SelectPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val columns: List<Column>,
    private val table: Table
) : PrintTask {

    override fun print(): String {
        if (!columns.isEmpty()) {
            val columnList = columns
                .map { SelectColumnPrintTask(optionMap, it) }
                .map { it.print() }
                .joinToString(separator = ", ")
            return fullSelectStatement(columnList)
        } else {
            return shortSelectStatement()
        }
    }

    private fun fullSelectStatement(columnList: String): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            "select $columnList from ${tableNameExpression()}"
        } else {
            "SELECT $columnList FROM ${tableNameExpression()}"
        }
    }

    private fun shortSelectStatement(): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            "select * from ${tableNameExpression()}"
        } else {
            "SELECT * FROM ${tableNameExpression()}"
        }
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
            table.name.toUpperCase()
        } else {
            table.name.toLowerCase()
        }
    }

    private fun tableAliasExpression(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        val tableAliasCased = if (identifierCaseValue == CaseOption.UPPER.value) {
            table.alias.toUpperCase()
        } else {
            table.alias.toLowerCase()
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