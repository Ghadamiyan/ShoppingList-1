package com.example.shoppinglist_v4.database;


import androidx.lifecycle.LiveData;
import android.content.Context;

import com.example.shoppinglist_v4.async.DeleteAsyncTask;
import com.example.shoppinglist_v4.async.InsertAsyncTask;
import com.example.shoppinglist_v4.async.UpdateAsyncTask;
import com.example.shoppinglist_v4.models.Note;

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

    public LiveData<List<Note>> retrieveNotesTask() {
        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNoteTask(Note note){
        new DeleteAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }
}













