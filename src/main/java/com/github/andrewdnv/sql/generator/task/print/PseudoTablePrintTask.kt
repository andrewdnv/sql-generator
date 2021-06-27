package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.table.spi.PseudoTable

class PseudoTablePrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val table: PseudoTable
) : PrintTask {

    override fun print(): String {
        TODO("Not yet implemented")
    }

}