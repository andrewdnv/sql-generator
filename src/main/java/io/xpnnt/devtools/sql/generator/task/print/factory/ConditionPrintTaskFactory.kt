package io.xpnnt.devtools.sql.generator.task.print.factory

import io.xpnnt.devtools.sql.generator.condition.Condition
import io.xpnnt.devtools.sql.generator.condition.CustomCondition
import io.xpnnt.devtools.sql.generator.condition.GroupedCondition
import io.xpnnt.devtools.sql.generator.condition.SimpleCondition
import io.xpnnt.devtools.sql.generator.context.option.OptionName
import io.xpnnt.devtools.sql.generator.task.print.CustomConditionPrintTask
import io.xpnnt.devtools.sql.generator.task.print.GroupedConditionPrintTask
import io.xpnnt.devtools.sql.generator.task.print.PrintTask
import io.xpnnt.devtools.sql.generator.task.print.SimpleConditionPrintTask

object ConditionPrintTaskFactory {

    fun getTask(optionMap: Map<OptionName, Int>, condition: Condition): PrintTask {
        return if (condition is SimpleCondition) {
            SimpleConditionPrintTask(optionMap, condition)
        } else if (condition is CustomCondition) {
            CustomConditionPrintTask(optionMap, condition)
        } else {
            GroupedConditionPrintTask(optionMap, condition as GroupedCondition)
        }
    }

}