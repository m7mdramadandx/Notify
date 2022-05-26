package com.ramadan.notify.di

import android.app.Application
import androidx.room.Room
import com.ramadan.notify.data.data_source.NoteDatabase
import com.ramadan.notify.data.data_source.ToDoDatabase
import com.ramadan.notify.data.repository.NoteRepositoryImpl
import com.ramadan.notify.data.repository.ToDoRepositoryImpl
import com.ramadan.notify.domain.repository.NoteRepository
import com.ramadan.notify.domain.repository.ToDoRepository
import com.ramadan.notify.domain.use_case.note.*
import com.ramadan.notify.domain.use_case.todo.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        )
            .build()
    }


    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }

    @Provides
    @Singleton
    fun provideToDoDatabase(app: Application): ToDoDatabase {
        return Room.databaseBuilder(
            app,
            ToDoDatabase::class.java,
            ToDoDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun provideToDoRepository(db: ToDoDatabase): ToDoRepository {
        return ToDoRepositoryImpl(db.toDoDao)
    }

    @Provides
    @Singleton
    fun provideToDoUseCases(repository: ToDoRepository): ToDoUseCases {
        return ToDoUseCases(
            getToDos = GetToDos(repository),
            deleteToDo = DeleteToDo(repository),
            addToDo = AddToDo(repository),
            markToDo = MarkToDo(repository),
            getToDo = GetToDo(repository)
        )
    }

}