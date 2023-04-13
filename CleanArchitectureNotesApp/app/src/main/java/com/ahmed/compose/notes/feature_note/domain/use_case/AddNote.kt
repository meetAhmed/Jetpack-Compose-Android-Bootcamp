package com.ahmed.compose.notes.feature_note.domain.use_case

import com.ahmed.compose.notes.feature_note.domain.model.InvalidNoteException
import com.ahmed.compose.notes.feature_note.domain.model.Note
import com.ahmed.compose.notes.feature_note.domain.repository.NoteRepository

class AddNote(
    private val noteRepository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Note Title must not be empty.")
        }
        if (note.title.isBlank()) {
            throw InvalidNoteException("Note content must not be empty.")
        }
        noteRepository.insert(note)
    }
}

