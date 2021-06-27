package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.*
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.PseudoColumn

class SelectColumnPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val column: Column
) : PrintTask {

    override fun print(): String {
        val useColumnAliasValue = optionMap[OptionName.USE_COLUMN_ALIAS]
        return if (column is PseudoColumn) {
            "${column.expression} ${columnAliasExpression()}"
        } else if (useColumnAliasValue == ChoiceOption.NO.value) {
            columnName()
        } else {
            "${columnName()} ${columnAliasExpression()}"
        }
    }

    private fun columnName(): String {
        val useColumnPrefixValue = optionMap[OptionName.USE_COLUMN_PREFIX]
        val columnName = if (useColumnPrefixValue == ChoiceOption.NO.value) {
            column.name!!
        } else {
            "${tableName()}.${column.name!!}"
        }
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            columnName.toUpperCase()
        } else {
            columnName.toLowerCase()
        }
    }

    private fun tableName(): String {
        val useTableAliasValue = optionMap[OptionName.USE_TABLE_ALIAS]
        return if (useTableAliasValue == ChoiceOption.YES.value) {
            column.table.alias
        } else {
            column.table.name
        }
    }

    private fun columnAliasExpression(): String {
        val columnAliasFormValue = optionMap[OptionName.COLUMN_ALIAS_FORM]
        val columnAlias = if (columnAliasFormValue == FormOption.SHORT.value) {
            column.alias
        } else {
            "${column.table.alias}_${column.alias}"
        }
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        val columnAliasCased = if (identifierCaseValue == CaseOption.UPPER.value) {
            columnAlias.toUpperCase()
        } else {
            columnAlias.toLowerCase()
        }
        return "${columnAliasWord()}$columnAliasCased"
    }

    private fun columnAliasWord(): String {
        val columnAliasWordValue = optionMap[OptionName.ALIAS_WORD]
        val columnAliasWord = if (columnAliasWordValue == AliasOption.NONE.value) {
            ""
        } else {
            "as "
        }
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            columnAliasWord.toLowerCase()
        } else {
            columnAliasWord.toUpperCase()
        }
    }

}