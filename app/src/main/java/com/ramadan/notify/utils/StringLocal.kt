package com.ramadan.notify.utils

import androidx.annotation.StringRes
import com.ramadan.notify.Application

object StringLocal {

    fun localize(@StringRes resId: Int): String {
        try {
            return Application.getAppContext().getString(resId)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

}