package com.ahmed.compose.notes.feature_note.data.data_source

import androidx.room.*
import com.ahmed.compose.notes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * from note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * from note where id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)
}