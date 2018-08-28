// !LANGUAGE: +AllowContractsForCustomFunctions +UseCallsInPlaceEffect
// !WITH_CONTRACT_FUNCTIONS

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (NEGATIVE)

 SECTION: Contracts
 CATEGORY: analysis, controlflow, initialization
 NUMBER: 6
 DESCRIPTION: Check the lack of CallsInPlace effect on the lambda in the parentheses.
 UNEXPECTED BEHAVIOUR
 ISSUES: KT-26229
 */

fun case_1() {
    val value_1: Int
    funWithExactlyOnceCallsInPlace({ <!CAPTURED_VAL_INITIALIZATION!>value_1<!> = 11 })
    <!UNINITIALIZED_VARIABLE!>value_1<!>.inc()
}

fun case_2() {
    var value_1: Int
    funWithAtLeastOnceCallsInPlace({ value_1 = 11 })
    <!UNINITIALIZED_VARIABLE!>value_1<!>.inc()
}
