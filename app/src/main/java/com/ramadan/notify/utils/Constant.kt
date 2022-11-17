package com.ramadan.notify.utils

import android.os.Environment

object Constant {

    val PREF_NAME = "SharedPref"

    const val CHANNEL_ID = "StarWarsChannel"
    const val CHANNEL_NAME = "StarWarsChannelName"
    const val CHANNEL_DESCRIPTION = "StarWarsChannelDescription"

    const val SERVICE_COMMAND = "Command"
    const val NOTIFICATION_TEXT = "NotificationText"
    const val TIMER_ACTION = "TimerAction"


    const val DEBUG_TAG = "NOTIFY_LOGCAT"

    val dirPath = Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_PICTURES
    ).path + "/islami"

    const val OUTPUT_PATH = "blur_filter_outputs"
    const val KEY_IMAGE_URI = "KEY"
    const val TAG_OUTPUT = "OUTPUT"
}