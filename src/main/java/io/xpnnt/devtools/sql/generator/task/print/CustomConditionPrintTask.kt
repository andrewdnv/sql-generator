package io.xpnnt.devtools.sql.generator.task.print

import io.xpnnt.devtools.sql.generator.condition.CustomCondition
import io.xpnnt.devtools.sql.generator.context.option.*
import io.xpnnt.devtools.sql.generator.table.PseudoColumn

class CustomConditionPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val condition: CustomCondition
) : PrintTask {

    override fun print(): String {
        return if (condition.column != null) {
            "(${column()} ${condition.expression.trim()})"
        } else {
            "(${condition.expression.trim().removePrefix("(").removeSuffix(")")})"
        }
    }

    private fun column(): String {
        val useColumnAliasValue = optionMap[OptionName.USE_COLUMN_ALIAS]
        val column = if (condition.column is PseudoColumn) {
            columnAlias()
        } else if (useColumnAliasValue == ChoiceOption.NO.value) {
            "${tableNameExpression()}.${columnName()}"
        } else {
            columnAlias()
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
            condition.column!!.table.name.toUpperCase()
        } else {
            condition.column!!.table.name.toLowerCase()
        }
    }

    private fun tableAlias(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            condition.column!!.table.alias.toUpperCase()
        } else {
            condition.column!!.table.alias.toLowerCase()
        }
    }

    private fun columnName(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            condition.column!!.name!!.toUpperCase()
        } else {
            condition.column!!.name!!.toLowerCase()
        }
    }

    private fun columnAlias(): String {
        val columnAliasFormValue = optionMap[OptionName.COLUMN_ALIAS_FORM]
        val columnAlias = if (columnAliasFormValue == FormOption.SHORT.value) {
            condition.column!!.alias
        } else {
            "${condition.column!!.table.alias}_${condition.column.alias}"
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

}