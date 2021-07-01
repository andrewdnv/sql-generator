package com.github.andrewdnv.sql.generator.task.print

import com.github.andrewdnv.sql.generator.condition.Condition
import com.github.andrewdnv.sql.generator.condition.GroupedCondition
import com.github.andrewdnv.sql.generator.context.option.CaseOption
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.task.print.factory.ConditionPrintTaskFactory

class GroupedConditionPrintTask(
    private val optionMap: Map<OptionName, Int>,
    private val condition: GroupedCondition
) : PrintTask {

    override fun print(): String {
        return "(${conditionsExpression()})"
    }

    private fun conditionsExpression(): String =
        condition.conditions.map { condition(it) }.joinToString ( " ${connector()} " )

    private fun condition(innerCondition: Condition): String =
        ConditionPrintTaskFactory.getTask(optionMap, innerCondition).print()

    private fun connector(): String {
        val keywordCaseValue = optionMap[OptionName.KEYWORD_CASE]
        return if (keywordCaseValue == CaseOption.LOWER.value) {
            condition.connector.value.toLowerCase()
        } else {
            condition.connector.value.toUpperCase()
        }
    }

}