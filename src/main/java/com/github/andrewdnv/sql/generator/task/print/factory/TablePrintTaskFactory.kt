package com.github.andrewdnv.sql.generator.task.print.factory

import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.table.spi.PseudoTable
import com.github.andrewdnv.sql.generator.table.spi.SimpleTable
import com.github.andrewdnv.sql.generator.table.spi.Table
import com.github.andrewdnv.sql.generator.task.print.*

object TablePrintTaskFactory {

    fun getTask(optionMap: Map<OptionName, Int>, table: Table): PrintTask {
        return if (table is SimpleTable) {
            SimpleTablePrintTask(optionMap, table)
        } else {
            PseudoTablePrintTask(optionMap, table as PseudoTable)
        }
    }

}