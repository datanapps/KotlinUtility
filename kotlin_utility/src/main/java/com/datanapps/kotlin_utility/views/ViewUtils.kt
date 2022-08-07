package com.datanapps.kotlin_utility.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes

/*
* Created by Yogendra on 12/7/2022
* The purpose of this class to have views utils
*/


/*
* Debug
* */

fun ViewGroup.inflate(@LayoutRes layoutId: Int) =
    LayoutInflater.from(context).inflate(layoutId, this, false)


fun View.showKeyboard() {
    this.requestFocus()
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}