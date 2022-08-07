package com.datanapps.kotlin_utility.strings

import android.util.Patterns
import androidx.core.text.HtmlCompat
import java.util.regex.Pattern

/*
* Created by Yogendra on 12/7/2022
* The purpose of this class to have define string manipulations
*/


/*
* Debug
* */

fun String?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()


/**
 * at least 1 character AND
 * at least 1 numeric AND
 * at least 1 special char AND
 * at length should be 8 in length
 */
fun String?.isValidPassword() = this != null
        && Pattern.compile("^(?=.*[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@\$%^&*-]).{8,}\$").matcher(this)
    .matches()

/*
*
* validate null or empty
* */
fun String?.isNotNullOrEmpty() = !isNullOrEmpty()

fun String?.isNull() = this == null


/*
* Length
* */

fun String?.isValidLength(length: Int = 0) =
    if (this.isNullOrEmpty()) false else this.length == length


/*
* HTML
* */

fun String?.getHTMLText() = HtmlCompat.fromHtml(this ?: "", HtmlCompat.FROM_HTML_MODE_LEGACY)


fun String.startWithHttp() = when {
        this.startsWith("http") -> this
        this.isNotEmpty() -> "https://www.".plus(this)
        else -> ""
    }

