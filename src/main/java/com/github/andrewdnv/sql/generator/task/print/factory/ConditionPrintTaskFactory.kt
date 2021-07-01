package com.github.andrewdnv.sql.generator.task.print.factory

import com.github.andrewdnv.sql.generator.condition.Condition
import com.github.andrewdnv.sql.generator.condition.CustomCondition
import com.github.andrewdnv.sql.generator.condition.GroupedCondition
import com.github.andrewdnv.sql.generator.condition.SimpleCondition
import com.github.andrewdnv.sql.generator.context.option.OptionName
import com.github.andrewdnv.sql.generator.task.print.CustomConditionPrintTask
import com.github.andrewdnv.sql.generator.task.print.GroupedConditionPrintTask
import com.github.andrewdnv.sql.generator.task.print.PrintTask
import com.github.andrewdnv.sql.generator.task.print.SimpleConditionPrintTask

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