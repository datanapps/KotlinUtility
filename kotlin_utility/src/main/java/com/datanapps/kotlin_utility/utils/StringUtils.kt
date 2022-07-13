package com.datanapps.kotlin_utility.utils

import android.util.Patterns

/*
* Created by Yogendra on 12/7/2022
* The purpose of this class to have define string manipulations
*/


/*
* Debug
* */

fun String?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String?.isNotNullOrEmpty() = !isNullOrEmpty()

fun String?.isNull() = this == null