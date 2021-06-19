package io.xpnnt.devtools.sql.generator.task.print

import io.xpnnt.devtools.sql.generator.context.option.CaseOption
import io.xpnnt.devtools.sql.generator.context.option.OptionName
import io.xpnnt.devtools.sql.generator.table.Column

class InsertColumnPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val column: Column
) : PrintTask {

    override fun print(): String {
        val identifierCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        return if (identifierCaseValue == CaseOption.UPPER.value) {
            column.name!!.toUpperCase()
        } else {
            column.name!!.toLowerCase()
        }
    }

}