package com.simprints.supermatcher.util

import com.simprints.supermatcher.data.Candidate
import com.simprints.supermatcher.util.Constant.FIRST_ALPHABET_ASCII
import com.simprints.supermatcher.util.Constant.LAST_ALPHABET_ASCII
import com.simprints.supermatcher.util.Constant.STARTER_NUMBER_VALUE
import java.security.InvalidParameterException


fun Candidate.toSignature(): Int = this.name.toSignature() + this.surname.toSignature()

fun String.toSignature(): Int = this.sumBy(::charToNumericValue)

fun charToNumericValue(character: Char): Int {
    val lowerCaseASCII = character.toLowerCase().toInt()
    if (lowerCaseASCII in FIRST_ALPHABET_ASCII..LAST_ALPHABET_ASCII) {
        return lowerCaseASCII.minus(STARTER_NUMBER_VALUE)
    } else {
        throw InvalidParameterException()
    }
}