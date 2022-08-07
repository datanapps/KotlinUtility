package com.datanapps.kotlin_utility.views

import android.annotation.SuppressLint
import android.webkit.WebSettings
import android.webkit.WebView

/*
* Created by Yogendra on 12/7/2022
* The purpose of this class to have views utils
*/


@SuppressLint("SetJavaScriptEnabled")
fun WebView.enableDefaultSetting() {
    this.settings.javaScriptEnabled = true
    this.settings.loadWithOverviewMode = true
    this.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
    this.settings.domStorageEnabled = true
    this.settings.databaseEnabled = true
    this.settings.useWideViewPort = true
}
