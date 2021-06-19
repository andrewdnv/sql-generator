package io.xpnnt.devtools.sql.generator.task.print

import io.xpnnt.devtools.sql.generator.context.option.CaseOption
import io.xpnnt.devtools.sql.generator.context.option.OptionName
import io.xpnnt.devtools.sql.generator.table.TableColumn

class UpdateColumnPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val column: TableColumn
) : PrintTask {

    override fun print(): String {
        val identifiersCaseValue = optionMap[OptionName.IDENTIFIER_CASE]
        val columnName = if (identifiersCaseValue == CaseOption.UPPER.value) {
            column.name!!.toUpperCase()
        } else {
            column.name!!.toLowerCase()
        }
        return "$columnName = ${ParamPrintTask(optionMap, column).print()}"
    }

}