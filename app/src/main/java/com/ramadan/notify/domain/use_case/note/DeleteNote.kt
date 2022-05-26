package com.ramadan.notify.domain.use_case.note

import com.ramadan.notify.domain.model.Note
import com.ramadan.notify.domain.repository.NoteRepository

class DeleteNote(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note) = repository.deleteNote(note)
}