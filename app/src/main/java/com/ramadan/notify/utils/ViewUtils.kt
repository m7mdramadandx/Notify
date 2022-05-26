@file:Suppress("DEPRECATION")

package com.ramadan.notify.utils

import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Environment
import android.preference.PreferenceManager.getDefaultSharedPreferences


fun getRecordLength(milliseconds: Long): String {
    return String.format(
        "%02d:%02d",
        java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(milliseconds),
        java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(milliseconds) -
                java.util.concurrent.TimeUnit.MINUTES.toSeconds(
                    java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(
                        milliseconds
                    )
                )
    )

}

fun Context.setFirstOpen() {
    val prefs = getDefaultSharedPreferences(this)
    prefs.edit().apply {
        putBoolean("FIRST_OPEN", false)
        apply()
    }
}

fun Context.getFirstOpen(): Boolean {
    val prefs = getDefaultSharedPreferences(this)
    return prefs.getBoolean("FIRST_OPEN", true)
}


val menuItemColor = Color.rgb(238, 238, 238)
const val debug_tag = "TOTO"
const val STORAGE_PERMISSION = 1001
const val tryAgainMsg = "Sorry, try again later."
val recordsDirPath = Environment.getExternalStorageDirectory().path + "/Notify/Records/"
val whiteboardDirPath =
    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).path + "/Notify"

fun Context.isNetworkConnected(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
}



