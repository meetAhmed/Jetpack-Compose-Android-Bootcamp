package com.ahmed.compose.notes.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmed.compose.notes.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {
    abstract val dao: NoteDao

    companion object {
        const val DatabaseName = "Notes"
    }
}