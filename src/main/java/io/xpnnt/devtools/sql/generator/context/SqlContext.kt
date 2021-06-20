package io.xpnnt.devtools.sql.generator.context

import io.xpnnt.devtools.sql.generator.builder.spi.ConditionBuilder
import io.xpnnt.devtools.sql.generator.context.option.*
import io.xpnnt.devtools.sql.generator.table.spi.Table

class SqlContext<T : Table, C : ConditionBuilder<T, C>>(val table: T) {

    val optionMap: MutableMap<OptionName, Int> = mutableMapOf(
        OptionName.KEYWORD_CASE to CaseOption.UPPER.value,
        OptionName.IDENTIFIER_CASE to CaseOption.LOWER.value,
        OptionName.PARAMETER_CASE to CaseOption.AS_IS.value,
        OptionName.USE_TABLE_ALIAS to ChoiceOption.NO.value,
        OptionName.USE_COLUMN_ALIAS to ChoiceOption.YES.value,
        OptionName.USE_COLUMN_PREFIX to ChoiceOption.YES.value,
        OptionName.COLUMN_ALIAS_FORM to FormOption.FULL.value,
        OptionName.ALIAS_WORD to AliasOption.AS.value,
        OptionName.COMPARISON_CONNECTOR to ConnectorOption.AND.value
    )

    lateinit var conditionBuilder: C

    // TODO: implement

}

typealias Context<T, C> = SqlContext<T, C>