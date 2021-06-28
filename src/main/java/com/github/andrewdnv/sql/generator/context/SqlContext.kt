package com.github.andrewdnv.sql.generator.context

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.condition.ConditionType
import com.github.andrewdnv.sql.generator.context.option.*
import com.github.andrewdnv.sql.generator.table.spi.TableFactory

class SqlContext<TF : TableFactory<TF, CB>, CB : ConditionBuilder<TF, CB>>(private val tableFactory: TableFactory<TF, CB>) {

    val optionMap: MutableMap<OptionName, Int> = mutableMapOf(
        OptionName.KEYWORD_CASE to CaseOption.UPPER.value,
        OptionName.IDENTIFIER_CASE to CaseOption.LOWER.value,
        OptionName.PARAMETER_CASE to CaseOption.AS_IS.value,
        OptionName.USE_TABLE_ALIAS to ChoiceOption.NO.value,
        OptionName.USE_COLUMN_ALIAS to ChoiceOption.YES.value,
        OptionName.USE_COLUMN_PREFIX to ChoiceOption.YES.value,
        OptionName.COLUMN_ALIAS_FORM to FormOption.FULL.value,
        OptionName.ALIAS_WORD to AliasOption.AS.value,
        OptionName.RESULT_COMPARISON_CONNECTOR to ConnectorOption.AND.value
    )

    var mainClause: String = ""
        set(value) { if (field.isEmpty()) field = value else return }

    var whereClause: String = ""
        set(value) { if (field.isEmpty()) field = value else return }

    var groupClause: String = ""
        set(value) { if (field.isEmpty()) field = value else return }

    var havingClause: String = ""
        set(value) { if (field.isEmpty()) field = value else return }

    var orderClause: String = ""
        set(value) { if (field.isEmpty()) field = value else return }

    fun table() = tableFactory.table()

    fun conditionBuilder(type: ConditionType) = tableFactory.conditionBuilder(this, type)

    fun sql() = listOf(mainClause, whereClause, groupClause, havingClause, orderClause)
        .filter { !it.isEmpty() }
        .joinToString { " " }

}

typealias Context<TF, CB> = SqlContext<TF, CB>