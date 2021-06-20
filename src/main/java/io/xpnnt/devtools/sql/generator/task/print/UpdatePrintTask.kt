package io.xpnnt.devtools.sql.generator.task.print

import io.xpnnt.devtools.sql.generator.context.option.CaseOption
import io.xpnnt.devtools.sql.generator.context.option.OptionName
import io.xpnnt.devtools.sql.generator.table.Column
import io.xpnnt.devtools.sql.generator.table.spi.Table

class UpdatePrintTask(
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
        val columnList = columns
            .map { UpdateColumnPrintTask(optionMap, it) }
            .map { it.print() }
            .joinToString(separator = ", ")
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            "update $tableName set $columnList"
        } else {
            "UPDATE $tableName SET $columnList"
        }
    }

}