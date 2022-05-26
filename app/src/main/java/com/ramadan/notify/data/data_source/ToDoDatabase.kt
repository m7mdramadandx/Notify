package com.ramadan.notify.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ramadan.notify.domain.model.ToDo

@Database(
    entities = [ToDo::class],
    version = 2,
    exportSchema = false
)
abstract class ToDoDatabase : RoomDatabase() {

    abstract val toDoDao: ToDoDao

    companion object {
        const val DATABASE_NAME = "todo_db"
    }
}