package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.*
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.spi.Table
import com.github.andrewdnv.sql.generator.task.print.factory.TablePrintTaskFactory

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
            "select $columnList from ${TablePrintTaskFactory.getTask(optionMap, table)}"
        } else {
            "SELECT $columnList FROM ${TablePrintTaskFactory.getTask(optionMap, table)}"
        }
    }

    private fun shortSelectStatement(): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            "select * from ${TablePrintTaskFactory.getTask(optionMap, table)}"
        } else {
            "SELECT * FROM ${TablePrintTaskFactory.getTask(optionMap, table)}"
        }
    }

}