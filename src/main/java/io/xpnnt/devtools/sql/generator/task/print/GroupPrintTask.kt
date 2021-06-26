package io.xpnnt.devtools.sql.generator.task.print

import io.xpnnt.devtools.sql.generator.context.option.CaseOption
import io.xpnnt.devtools.sql.generator.context.option.OptionName
import io.xpnnt.devtools.sql.generator.table.Column

class GroupPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val columns: List<Column>
) : PrintTask {

    override fun print(): String {
        return "${keyword()} ${columnsExpression()}"
    }

    private fun keyword(): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            "group by"
        } else {
            "GROUP BY"
        }
    }

    private fun columnsExpression(): String = columns
        .map { GroupColumnPrintTask(optionMap, it) }
        .map { it.print() }
        .joinToString { ", " }

}