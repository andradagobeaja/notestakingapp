package com.example.notetakingapp.data

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {
    val readAllNotes: LiveData<List<Note>> = noteDao.readAllData()

    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }
}