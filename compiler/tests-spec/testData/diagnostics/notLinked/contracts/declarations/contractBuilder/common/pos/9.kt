// !LANGUAGE: +AllowContractsForCustomFunctions +UseCallsInPlaceEffect
// !DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER -UNUSED_VARIABLE -UNUSED_PARAMETER -UNREACHABLE_CODE -UNUSED_EXPRESSION

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (POSITIVE)

 SECTION: Contracts
 CATEGORY: declarations, contractBuilder, common
 NUMBER: 9
 DESCRIPTION: Contract function with CallsInPlace effect with not allowed implies.
 UNEXPECTED BEHAVIOUR
 ISSUES: KT-26409
 */

import kotlin.internal.contracts.*

fun case_1(value_1: Any?, block: () -> Unit) {
    contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) implies (value_1 != null) }
    if (value_1 != null) block()
}
