// !LANGUAGE: +AllowContractsForCustomFunctions +UseCallsInPlaceEffect
// !DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (POSITIVE)

 SECTION: Contracts
 CATEGORY: declarations, contractBuilder, effects, returns
 NUMBER: 6
 DESCRIPTION: Returns effect with type checking with generic parameter
 UNEXPECTED BEHAVIOUR
 ISSUES: KT-26296
 */

import kotlin.internal.contracts.*

fun <T : Number?> T.case_1() {
    contract { returns() implies (<!USELESS_IS_CHECK!>this@case_1 is T<!>) }
    if (!(<!USELESS_IS_CHECK!>this@case_1 is T<!>)) throw Exception()
}

fun <T : Number, K : <!FINAL_UPPER_BOUND!>String<!>> T?.case_2(value_1: K?) {
    contract { returns() implies (this@case_2 is T && value_1 is K) }
    if (!(this@case_2 is T && value_1 is K)) throw Exception()
}

inline fun <reified T : Number> T?.case_3(value_1: Any?) {
    contract { returns() implies (value_1 is T) }
    if (!(value_1 is T)) throw Exception()
}

inline fun <reified T : Number, K> K?.case_4(value_1: Any?) {
    contract { returns() implies (this@case_4 !is T || value_1 is T) }
    if (!(this@case_4 !is T || value_1 is T)) throw Exception()
}
