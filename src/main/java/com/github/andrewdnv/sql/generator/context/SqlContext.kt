package com.github.andrewdnv.sql.generator.context

import com.github.andrewdnv.sql.generator.builder.spi.ConditionBuilder
import com.github.andrewdnv.sql.generator.context.option.*
import com.github.andrewdnv.sql.generator.table.spi.Table

class SqlContext<CB : ConditionBuilder<CB>>(val table: Table) {

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

    lateinit var conditionBuilder: CB

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

    fun sql() = listOf(mainClause, whereClause, groupClause, havingClause, orderClause)
        .filter { !it.isEmpty() }
        .joinToString { " " }

}

typealias Context<CB> = SqlContext<CB>