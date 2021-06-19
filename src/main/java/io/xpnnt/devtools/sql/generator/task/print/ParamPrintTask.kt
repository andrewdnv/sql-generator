package io.xpnnt.devtools.sql.generator.task.print

import io.xpnnt.devtools.sql.generator.context.option.CaseOption
import io.xpnnt.devtools.sql.generator.context.option.OptionName
import io.xpnnt.devtools.sql.generator.table.Column

class ParamPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val column: Column
) : PrintTask {

    override fun print(): String {
        val paramCaseValue = optionMap.get(OptionName.PARAMETER_CASE)
        val paramName = if (paramCaseValue == CaseOption.UPPER.value) {
            column.paramName.toUpperCase()
        } else if (paramCaseValue == CaseOption.LOWER.value) {
            column.paramName.toLowerCase()
        } else {
            column.paramName
        }
        return ":$paramName"
    }

}