package com.ahmed.compose.notes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ahmed.compose.notes.ui.theme.*

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val notesColor = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String) : Exception(message)