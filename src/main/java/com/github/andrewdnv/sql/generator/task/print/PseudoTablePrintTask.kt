package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.CaseOption
import com.github.andrewdnv.sql.generator.context.option.ChoiceOption
import com.github.andrewdnv.sql.generator.context.option.FormOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.join.TableJoin
import com.github.andrewdnv.sql.generator.table.TableColumn
import com.github.andrewdnv.sql.generator.table.spi.PseudoTable

class PseudoTablePrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val table: PseudoTable
) : PrintTask {

    override fun print(): String {
        return "${firstTable()} ${joinExpressions()}"
    }

    private fun firstTable(): String {
        return SimpleTablePrintTask(optionMap, table.tableJoins[0].firstColumn.table!!).print()
    }

    private fun joinExpressions(): String {
        return table.tableJoins.map { joinExpression(it) }.joinToString { " " }
    }

    private fun joinExpression(join: TableJoin): String {
        return "${joinWord(join)} ${SimpleTablePrintTask(optionMap, join.secondColumn.table!!).print()} ${onExpression(join)}"
    }

    private fun joinWord(tableJoin: TableJoin): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            tableJoin.joinType.value.toLowerCase()
        } else {
            tableJoin.joinType.value.toUpperCase()
        }
    }

    private fun onExpression(tableJoin: TableJoin): String {
        return "${onWord()} ${column(tableJoin.firstColumn)} = ${column(tableJoin.secondColumn)}"
    }

    private fun onWord(): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            "on"
        } else {
            "ON"
        }
    }

    private fun column(column: TableColumn): String {
        val useColumnAliasValue = optionMap[OptionName.USE_COLUMN_ALIAS]
        return if (useColumnAliasValue == ChoiceOption.NO.value) {
            columnName(column)
        } else {
            columnAlias(column)
        }
    }

    private fun columnName(column: TableColumn): String {
        val useColumnPrefixValue = optionMap[OptionName.USE_COLUMN_PREFIX]
        val columnName = if (useColumnPrefixValue == ChoiceOption.NO.value) {
            column.name!!
        } else {
            "${tableName(column)}.${column.name!!}"
        }
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            columnName.toUpperCase()
        } else {
            columnName.toLowerCase()
        }
    }

    private fun columnAlias(column: TableColumn): String {
        val columnAliasFormValue = optionMap[OptionName.COLUMN_ALIAS_FORM]
        val columnAlias = if (columnAliasFormValue == FormOption.SHORT.value) {
            column.alias
        } else {
            "${column.table!!.alias}_${column.alias}"
        }
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.LOWER.value) {
            columnAlias.toLowerCase()
        } else {
            columnAlias.toUpperCase()
        }
    }

    private fun tableName(column: TableColumn): String {
        val useTableAliasValue = optionMap[OptionName.USE_TABLE_ALIAS]
        return if (useTableAliasValue == ChoiceOption.YES.value) {
            column.table!!.alias!!
        } else {
            column.table!!.name!!
        }
    }

}