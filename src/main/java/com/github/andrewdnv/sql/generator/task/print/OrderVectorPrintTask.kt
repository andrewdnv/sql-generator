package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.CaseOption
import com.github.andrewdnv.sql.generator.context.option.ChoiceOption
import com.github.andrewdnv.sql.generator.context.option.FormOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.order.OrderVector
import com.github.andrewdnv.sql.generator.table.PseudoColumn

class OrderVectorPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val orderVector: OrderVector
) : PrintTask {

    override fun print(): String {
        return "(${column()} ${directionWord()})"
    }

    private fun column(): String {
        val useColumnAliasValue = optionMap[OptionName.USE_COLUMN_ALIAS]
        return if (orderVector.column is PseudoColumn) {
            columnAlias()
        } else if (useColumnAliasValue == ChoiceOption.NO.value) {
            "${tableNameExpression()}.${columnName()}"
        } else {
            columnAlias()
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
            orderVector.column.table.name.toUpperCase()
        } else {
            orderVector.column.table.name.toLowerCase()
        }
    }

    private fun tableAlias(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            orderVector.column.table.alias.toUpperCase()
        } else {
            orderVector.column.table.alias.toLowerCase()
        }
    }

    private fun columnName(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            orderVector.column.name!!.toUpperCase()
        } else {
            orderVector.column.name!!.toLowerCase()
        }
    }

    private fun columnAlias(): String {
        val columnAliasFormValue = optionMap[OptionName.COLUMN_ALIAS_FORM]
        val columnAlias = if (columnAliasFormValue == FormOption.SHORT.value) {
            orderVector.column.alias
        } else {
            "${orderVector.column.table.alias}_${orderVector.column.alias}"
        }
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            columnAlias.toUpperCase()
        } else {
            columnAlias.toLowerCase()
        }
    }

    private fun directionWord(): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            orderVector.direction.value.toLowerCase()
        } else {
            orderVector.direction.value.toUpperCase()
        }
    }

}