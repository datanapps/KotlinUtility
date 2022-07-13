package com.datanapps.kotlin_utility.utils

import com.datanapps.kotlin_utility.BuildConfig
import com.datanapps.kotlin_utility.TAG

/*
* Created by Yogendra on 12/7/2022
* The purpose of this class to print log
*/


object Logger {

/*
* Debug
* */

    fun d(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.d(tag, validateString(msg))
        }
    }


    fun d(msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.d(TAG, validateString(msg))
        }
    }

    fun d(msg: String, throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            android.util.Log.d(TAG, validateString(msg), throwable)
        }
    }

    fun d(msg: String, throwable: Error) {
        if (BuildConfig.DEBUG) {
            android.util.Log.d(TAG, validateString(msg), throwable)
        }
    }

    /*
    * ERROR
    * */

    fun e(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.e(tag, validateString(msg))
        }
    }

    fun e(msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.e(TAG, validateString(msg))
        }
    }

    fun e(msg: String, throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            android.util.Log.e(TAG, validateString(msg), throwable)
        }
    }

    fun e(msg: String, error: Error) {
        if (BuildConfig.DEBUG) {
            android.util.Log.e(TAG, validateString(msg), error)
        }
    }

    /*
    * INFO
    *
    * */

    fun i(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.i(tag, validateString(msg))
        }
    }

    fun i(msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.i(TAG, validateString(msg))
        }
    }

    fun i(msg: String, throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            android.util.Log.i(TAG, validateString(msg), throwable)
        }
    }


    fun i(msg: String, error: Error) {
        if (BuildConfig.DEBUG) {
            android.util.Log.i(TAG, validateString(msg), error)
        }
    }

/*
* VERBOSE
* */

    fun v(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.v(tag, validateString(msg))
        }
    }

    fun v(msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.v(TAG, validateString(msg))
        }
    }

    fun v(msg: String, throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            android.util.Log.v(TAG, validateString(msg), throwable)
        }
    }

    fun v(msg: String, error: Error) {
        if (BuildConfig.DEBUG) {
            android.util.Log.v(TAG, validateString(msg), error)
        }
    }

    /*
    * WARNING
    *
    * */


    fun w(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.w(tag, validateString(msg))
        }
    }

    fun w(msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.w(TAG, validateString(msg))
        }
    }

    fun w(msg: String, throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            android.util.Log.w(TAG, validateString(msg), throwable)
        }
    }

    fun w(msg: String, error: Error) {
        if (BuildConfig.DEBUG) {
            android.util.Log.w(TAG, validateString(msg), error)
        }
    }


    private fun validateString(msg: String?) = when {
        msg.isNullOrBlank() -> "NullOrBlank"
        msg.isNullOrEmpty() -> "NullOrEmpty"
        else -> msg
    }

}