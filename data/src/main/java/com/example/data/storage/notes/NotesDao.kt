package com.example.data.storage.notes

import androidx.room.*
import com.example.common.domain.models.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Query("SELECT * FROM note ORDER BY id DESC")
    fun getNotes() : Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int) : Note?

    @Query("SELECT * FROM note WHERE title = :title LIMIT 1")
    suspend fun noteWithTitle(title: String) : Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}