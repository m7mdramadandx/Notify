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


    const val DEBUG_TAG = "NOTIFY_0101 "

    val dirPath = Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_PICTURES
    ).path + "/islami"

}