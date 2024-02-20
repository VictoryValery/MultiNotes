package com.example.data.storage.notes

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.common.domain.models.Note

@Database(
    [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NotesDatabase : RoomDatabase() {

    abstract val noteDao: NotesDao

    companion object {
        const val DATABASE_NAME = "notesDB"
    }

}