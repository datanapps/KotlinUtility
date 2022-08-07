package com.datanapps.kotlin_utility.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.datanapps.kotlin_utility.R

/**
 * Created by Yogendra on 11/20/20.
 */
fun Context.createDialog(
    message: String,
    action: () -> Unit,
): AlertDialog {
    return AlertDialog.Builder(this)
        .setMessage(message)
        .setPositiveButton(getString(R.string.text_ok)) { _, _ ->
            action.invoke()
        }
        .setNegativeButton(getString(R.string.text_cancel)) { dialog, _ ->
            dialog.dismiss()
        }
        .create()
}

fun Context.createDialog(
    message: String?,
    @StringRes positiveText: Int,
    onPositiveClick: ((dialog: DialogInterface, which: Int) -> Unit) = { _, _ -> },
    ): Dialog {
    return android.app.AlertDialog.Builder(this)
        .setMessage(message)
        .setPositiveButton(positiveText) { dialog, which ->
            onPositiveClick(dialog, which)
        }
        .show()
}

fun Context.createDialog(
    title: String,
    message: String,
    button1Text: String,
    action1: () -> Unit,
): AlertDialog {
    return AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(button1Text) { dialog, _ ->
            dialog.dismiss()
            action1.invoke()
        }.create()
}

fun Context.createDialog(
    title: String,
    message: String,
    button1Text: String,
    button2Text: String,
    action1: () -> Unit,
    action2: () -> Unit,
): AlertDialog {
    return AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(button1Text) { dialog, _ ->
            dialog.dismiss()
            action1.invoke()
        }.setNegativeButton(button2Text){dialog, _ ->
            dialog.dismiss()
            action2.invoke()
        }
        .create()
}

