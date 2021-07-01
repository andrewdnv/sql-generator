package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.CaseOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.table.Column
import com.github.andrewdnv.sql.generator.table.spi.Table

class UpdatePrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val columns: List<Column>,
    private val table: Table
) : PrintTask {

    override fun print(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        val tableName = if (identifierCaseValue == CaseOption.UPPER.value) {
            table.name!!.toUpperCase()
        } else {
            table.name!!.toLowerCase()
        }
        val columnList = columns
            .map { UpdateColumnPrintTask(optionMap, it) }
            .map { it.print() }
            .joinToString( ", ")
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            "update $tableName set $columnList"
        } else {
            "UPDATE $tableName SET $columnList"
        }
    }

}