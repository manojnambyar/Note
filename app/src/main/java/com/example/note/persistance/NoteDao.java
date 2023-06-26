package com.example.note.persistance;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.note.model.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    Long[] insertNotes(Note... notes);

    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getNotes();

    @Query("SELECT * FROM notes where id=:id")
    LiveData<List<Note>> getNotes(int id);

    @Delete
    int deleteNotes(Note... notes);


    @Update
    int updateNotes(Note... notes);
}





