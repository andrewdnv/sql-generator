package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.condition.ComparisonOperator
import com.github.andrewdnv.sql.generator.condition.SimpleCondition
import com.github.andrewdnv.sql.generator.context.option.*
import com.github.andrewdnv.sql.generator.table.PseudoColumn

class SimpleConditionPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val condition: SimpleCondition
) : PrintTask {

    override fun print(): String {
        return "(${column()} ${comparison()})"
    }

    private fun column(): String {
        val useColumnAliasValue = optionMap[OptionName.USE_COLUMN_ALIAS]
        val column = if (condition.column is PseudoColumn) {
            columnAlias()
        } else if (useColumnAliasValue == ChoiceOption.YES.value) {
            columnAlias()
        } else {
            "${tableNameExpression()}.${columnName()}"
        }
        return if (condition.ignoreCase) {
            "${caseWord()}($column)"
        } else {
            column
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
            condition.column.table!!.name!!.toUpperCase()
        } else {
            condition.column.table!!.name!!.toLowerCase()
        }
    }

    private fun tableAlias(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            condition.column.table!!.alias!!.toUpperCase()
        } else {
            condition.column.table!!.alias!!.toLowerCase()
        }
    }

    private fun columnName(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            condition.column.name!!.toUpperCase()
        } else {
            condition.column.name!!.toLowerCase()
        }
    }

    private fun columnAlias(): String {
        val columnAliasFormValue = optionMap[OptionName.COLUMN_ALIAS_FORM]
        val columnAlias = if (columnAliasFormValue == FormOption.SHORT.value) {
            condition.column.alias
        } else if (condition.column.table != null) {
            "${condition.column.table.alias}_${condition.column.alias}"
        } else {
            condition.column.alias
        }
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.LOWER.value) {
            columnAlias.toLowerCase()
        } else {
            columnAlias.toUpperCase()
        }
    }

    private fun caseWord(): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            "uppercase"
        } else {
            "UPPERCASE"
        }
    }

    private fun comparison(): String {
        return when (condition.operator) {
            ComparisonOperator.IN,
            ComparisonOperator.NOT_IN -> "${operator()} (${parameter()})"
            else -> "${operator()} ${parameter()}"
        }
    }

    private fun operator(): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            condition.operator.value.toLowerCase()
        } else {
            condition.operator.value.toUpperCase()
        }
    }

    private fun parameter(): String {
        val parameter = ParamPrintTask(optionMap, condition.column).print()
        return if (condition.ignoreCase) {
            "${caseWord()}($parameter)"
        } else {
            parameter
        }
    }

}