package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.condition.Condition
import com.github.andrewdnv.sql.generator.condition.ConditionType
import com.github.andrewdnv.sql.generator.context.option.CaseOption
import com.github.andrewdnv.sql.generator.context.option.ConnectorOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.task.print.factory.ConditionPrintTaskFactory

class ResultConditionPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val type: ConditionType,
    private val conditions: List<Condition>
) : PrintTask {

    override fun print(): String {
        return "${keyword()} ${conditionsExpression()}"
    }

    private fun keyword(): String {
        val keyword = if (type == ConditionType.HAVING) {
            "having"
        } else {
            "where"
        }
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            keyword.toLowerCase()
        } else {
            keyword.toUpperCase()
        }
    }

    private fun conditionsExpression(): String =
        conditions.map { condition(it) }.joinToString { " ${connector()} " }

    private fun condition(innerCondition: Condition): String =
        ConditionPrintTaskFactory.getTask(optionMap, innerCondition).print()

    private fun connector(): String {
        val connectorValue = optionMap[OptionName.RESULT_COMPARISON_CONNECTOR]
        val connector = if (connectorValue == ConnectorOption.OR.value) {
            "or"
        } else {
            "and"
        }
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            connector.toLowerCase()
        } else {
            connector.toUpperCase()
        }
    }

}