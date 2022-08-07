package com.datanapps.kotlin_utility.context

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import com.datanapps.kotlin_utility.loggers.Logger
import com.datanapps.kotlin_utility.strings.startWithHttp
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability


/*
* Created by Yogendra on 12/7/2022
* The purpose of this class to have define context manipulations
*/


/*
* utility
* */

fun Context?.isNull() = this == null


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.copyToClipboard(text: CharSequence) {
    val clipboard = ContextCompat.getSystemService(this, ClipboardManager::class.java)
    val clip = ClipData.newPlainText("label", text)
    clipboard?.setPrimaryClip(clip)
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}


fun Context.getColorCompat(@ColorRes colorResId: Int) = ContextCompat.getColor(this, colorResId)


fun Context.createShareIntent(url: String, title: String? = null): Intent =
    Intent.createChooser(Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, url)
        type = "text/plain"
    }, title)


fun Context.openUrl(urlString: String?) {
    urlString?.let {
        val url = urlString.startWithHttp()
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        try {
            startActivity(intent)
        } catch (t: Throwable) {
            Logger.e(t)
        }
    }
}

fun Context.openPlayStore(url: String?) {

    url?.let {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

}


/*
*
* Dialog
* */


/*
* Configuration
* */


fun Context.isGmsAvailable() =
    ConnectionResult.SUCCESS == GoogleApiAvailability.getInstance()
        .isGooglePlayServicesAvailable(this)


//fun Context.isTablet() = resources.getBoolean(R.bool.is_tablet)

fun Context.isPortrait() = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT


/*
*
* Theme
* */

fun Context.isNightMode(): Boolean = !isDayMode()
fun Context.isDayMode() =
    when (resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK) {
        Configuration.UI_MODE_NIGHT_YES -> false
        else -> true
    }



/*
* Dimensions
* */

/** dp size to px size. */
fun Context.dpToPx(dp: Int): Int {
    val scale = resources.displayMetrics.density
    return (dp * scale).toInt()
}

/** px size to dp size. */
fun Context.pxToDp(px: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        px.toFloat(),
        resources.displayMetrics
    ).toInt()
}

fun Context.getDimensionPixelSize(@DimenRes dimenRes: Int) = resources.getDimensionPixelSize(
    dimenRes
)
