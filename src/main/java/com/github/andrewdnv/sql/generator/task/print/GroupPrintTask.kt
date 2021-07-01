package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.CaseOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.table.Column

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
        .joinToString ( ", " )

}