// !LANGUAGE: +AllowContractsForCustomFunctions +UseCallsInPlaceEffect
// !DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER -UNUSED_VARIABLE -UNUSED_PARAMETER -UNREACHABLE_CODE -UNUSED_EXPRESSION

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (NEGATIVE)

 SECTION: Contracts
 CATEGORY: declarations, contractBuilder, common
 NUMBER: 2
 DESCRIPTION: Contracts with not allowed simple conditions in implies
 */

import kotlin.internal.contracts.*

fun case_1(value_1: Boolean): Boolean {
    contract { returns(true) implies (<!ERROR_IN_CONTRACT_DESCRIPTION!>value_1 == true<!>) }
    return value_1 == true
}

fun case_2(value_1: Boolean): Boolean? {
    contract { returnsNotNull() implies (<!ERROR_IN_CONTRACT_DESCRIPTION!>value_1 != false<!>) }
    return if (value_1 != false) true else null
}

fun case_3(value_1: String): Boolean {
    contract { returns(false) implies (value_1 != "") }
    return !(value_1 != "")
}

fun case_4(value_1: Int): Boolean? {
    contract { returns(null) implies (value_1 == 0) }
    return if (value_1 == 0) null else true
}
