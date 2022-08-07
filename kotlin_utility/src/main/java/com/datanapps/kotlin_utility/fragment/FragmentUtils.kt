package com.datanapps.kotlin_utility.fragment

import android.app.Dialog
import android.content.DialogInterface
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.datanapps.kotlin_utility.dialog.createDialog

/**
 * Created by Yogendra on 11/20/20.
 */
fun Fragment.createDialog(
    message: String,
    action: () -> Unit,
): AlertDialog = this.requireContext().createDialog(
    message,
    action
)

fun Fragment.createDialog(
    message: String?,
    @StringRes positiveText: Int,
    onPositiveClick: ((dialog: DialogInterface, which: Int) -> Unit) = { _, _ -> },
): Dialog = this.requireContext().createDialog(
    message,
    positiveText,
    onPositiveClick,
)

fun Fragment.createDialog(
    title: String,
    message: String,
    button1Text: String,
    action1: () -> Unit,
): AlertDialog = this.requireContext().createDialog(
    title,
    message,
    button1Text,
    action1
)

fun Fragment.createDialog(
    title: String,
    message: String,
    button1Text: String,
    button2Text: String,
    action1: () -> Unit,
    action2: () -> Unit,
): AlertDialog = this.requireContext().createDialog(
    title,
    message,
    button1Text,
    button2Text,
    action1,
    action2
)



