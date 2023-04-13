package com.ahmed.compose.notes.feature_note.data.repository

import com.ahmed.compose.notes.feature_note.data.data_source.NoteDao
import com.ahmed.compose.notes.feature_note.domain.model.Note
import com.ahmed.compose.notes.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> = dao.getNotes()

    override suspend fun getNoteById(id: Int): Note? = dao.getNoteById(id)

    override suspend fun insert(note: Note) {
        dao.insert(note)
    }

    override suspend fun delete(note: Note) {
        dao.delete(note)
    }
}