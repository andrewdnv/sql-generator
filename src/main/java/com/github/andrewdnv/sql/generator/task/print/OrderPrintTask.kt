package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.context.option.CaseOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.order.OrderVector

class OrderPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val orderVectors: List<OrderVector>
) : PrintTask {

    override fun print(): String {
        return "${keyword()} ${orderVectorsExpression()}"
    }

    private fun keyword(): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            "order by"
        } else {
            "ORDER BY"
        }
    }

    private fun orderVectorsExpression(): String = orderVectors
        .map { OrderVectorPrintTask(optionMap, it) }
        .map { it.print() }
        .joinToString ( ", " )

}