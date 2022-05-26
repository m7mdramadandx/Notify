package com.ramadan.notify.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    val title: String,
    var isDone: Boolean,
    val timestamp: Long,
    @PrimaryKey val id: Int? = null,
) {
    companion object {
//        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

