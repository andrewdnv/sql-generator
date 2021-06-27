package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.CaseOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.spi.Table

class InsertPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val columns: List<Column>,
    private val table: Table
) : PrintTask {

    override fun print(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        val tableName = if (identifierCaseValue == CaseOption.UPPER.value) {
            table.name.toUpperCase()
        } else {
            table.name.toLowerCase()
        }
        val paramList = columns
            .map { ParamPrintTask(optionMap, it) }
            .map { it.print() }
            .joinToString(separator = ", ")
        if (!columns.isEmpty()) {
            val columnList = columns
                .map { InsertColumnPrintTask(optionMap, it) }
                .map { it.print() }
                .joinToString(separator = ", ")
            return fullInsertStatement(tableName, columnList, paramList)
        } else {
            return shortInsertStatement(tableName, paramList)
        }

    }

    private fun fullInsertStatement(tableName: String, columnList: String, paramList: String): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            "insert into $tableName ($columnList) values ($paramList)"
        } else {
            "INSERT INTO $tableName ($columnList) VALUES ($paramList)"
        }
    }

    private fun shortInsertStatement(tableName: String, paramList: String): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            "insert into $tableName values ($paramList)"
        } else {
            "INSERT INTO $tableName VALUES ($paramList)"
        }
    }

}