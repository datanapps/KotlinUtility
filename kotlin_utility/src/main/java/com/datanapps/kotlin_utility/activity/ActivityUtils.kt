package com.datanapps.kotlin_utility.activity

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.datanapps.kotlin_utility.dialog.createDialog

/**
 * Created by Yogendra on 11/20/20.
 */
fun Activity.createDialog(
    message: String,
    action: () -> Unit,
): AlertDialog = this.createDialog(
    message,
    action
)

fun Activity.createDialog(
    message: String?,
    @StringRes positiveText: Int,
    onPositiveClick: ((dialog: DialogInterface, which: Int) -> Unit) = { _, _ -> },
): Dialog = this.createDialog(
    message,
    positiveText,
    onPositiveClick,
)

fun Activity.createDialog(
    title: String,
    message: String,
    button1Text: String,
    action1: () -> Unit,
): AlertDialog = this.createDialog(
    title,
    message,
    button1Text,
    action1
)

fun Activity.createDialog(
    title: String,
    message: String,
    button1Text: String,
    button2Text: String,
    action1: () -> Unit,
    action2: () -> Unit,
): AlertDialog = this.createDialog(
    title,
    message,
    button1Text,
    button2Text,
    action1,
    action2
)




