package com.ramadan.notify.domain.model

import androidx.compose.ui.graphics.toArgb
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ramadan.notify.ui.theme.MyColor

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null,
) {
    companion object {
        val noteColors =
            listOf(MyColor.RedOrange,
                MyColor.LightGreen,
                MyColor.Violet,
                MyColor.BabyBlue,
                MyColor.RedPink)

        val defaultNote =
            Note("Note Title", "Content", 55, MyColor.RedOrange.toArgb())

        val defaultNote2 =
            Note("Note Title",
                "Content Content ContentContent Content ContentContent Content ContentContent Content Content ",
                55,
                MyColor.BabyBlue.toArgb())
    }
}

