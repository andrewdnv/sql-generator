package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.CaseOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.table.Column

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