package com.ramadan.notify.data.data_source

import androidx.room.*
import com.ramadan.notify.domain.model.ToDo
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM toDo")
    fun getToDos(): Flow<List<ToDo>>

    @Query("SELECT * FROM toDo WHERE id = :id")
    suspend fun getToDoById(id: Int): ToDo?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(toDo: ToDo)

    @Update
    suspend fun updateToDo(toDo: ToDo)

    @Delete
    suspend fun deleteToDo(toDo: ToDo)
}