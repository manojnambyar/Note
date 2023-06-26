package com.example.note.persistance;

import android.content.Context;
import androidx.lifecycle.LiveData;

import com.example.note.async.DeleteAsyncTask;
import com.example.note.async.InsertAsyncTask;
import com.example.note.async.UpdateAsyncTask;
import com.example.note.model.Note;
import java.util.List;

public class NoteRepository {

    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context) {

        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNoteTask(Note note){
        new InsertAsyncTask(mNoteDatabase.getNoteDao()).execute(note);

    }

    public void updateNoteTask(Note note){
        new UpdateAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }

    public LiveData<List<Note>> retrieveNoteTask(){

        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNoteTask(Note note){
        new DeleteAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }




}





