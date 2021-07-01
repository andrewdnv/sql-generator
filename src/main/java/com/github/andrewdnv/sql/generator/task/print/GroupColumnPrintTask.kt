package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.CaseOption
import com.github.andrewdnv.sql.generator.context.option.ChoiceOption
import com.github.andrewdnv.sql.generator.context.option.FormOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.PseudoColumn

class GroupColumnPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val column: Column
) : PrintTask {

    override fun print(): String {
        return column()
    }

    private fun column(): String {
        val useColumnAliasValue = optionMap[OptionName.USE_COLUMN_ALIAS]
        return if (column is PseudoColumn) {
            columnAlias()
        } else if (useColumnAliasValue == ChoiceOption.YES.value) {
            columnAlias()
        } else {
            "${tableNameExpression()}.${columnName()}"
        }
    }

    private fun tableNameExpression(): String {
        val useTableAliasValue = optionMap[OptionName.USE_TABLE_ALIAS]
        return if (useTableAliasValue == ChoiceOption.YES.value) {
            tableAlias()
        } else {
            tableName()
        }
    }

    private fun tableName(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            column.table!!.name!!.toUpperCase()
        } else {
            column.table!!.name!!.toLowerCase()
        }
    }

    private fun tableAlias(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            column.table!!.alias!!.toUpperCase()
        } else {
            column.table!!.alias!!.toLowerCase()
        }
    }

    private fun columnName(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            column.name!!.toUpperCase()
        } else {
            column.name!!.toLowerCase()
        }
    }

    private fun columnAlias(): String {
        val columnAliasFormValue = optionMap[OptionName.COLUMN_ALIAS_FORM]
        val columnAlias = if (columnAliasFormValue == FormOption.SHORT.value) {
            column.alias
        } else if (column.table != null) {
            "${column.table.alias}_${column.alias}"
        } else {
            column.alias
        }
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.LOWER.value) {
            columnAlias.toLowerCase()
        } else {
            columnAlias.toUpperCase()
        }
    }

}