package com.example.note.adapters;


import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.note.R;
import com.example.note.model.Note;

import java.util.ArrayList;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder>{

    private ArrayList<Note> mNotes = new ArrayList<>();
    private  OnNoteListener mOnNoteListener;

    public NotesRecyclerAdapter(ArrayList<Note> notes,OnNoteListener onNoteListener) {
        this.mNotes = notes;
        this.mOnNoteListener=onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note_list_item,parent,false);
        return new ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(mNotes.get(position).getTitle());
        holder.timestamp.setText(mNotes.get(position).getTimestamp());

    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title, timestamp;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView,OnNoteListener onNoteListener) {
            super(itemView);
            title=itemView.findViewById(R.id.note_title);
            timestamp=itemView.findViewById(R.id.note_timestamp);
            itemView.setOnClickListener(this);
            this.onNoteListener=onNoteListener;
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
