package com.ahmed.compose.notes.feature_note.presentation.notes

import com.ahmed.compose.notes.feature_note.domain.model.Note
import com.ahmed.compose.notes.feature_note.domain.util.NoteOrder
import com.ahmed.compose.notes.feature_note.domain.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)