package com.example.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.Database.NoteEntity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    List<NoteEntity> noteList;
    OnUserClickListener onUserClickListener;

    RecyclerViewAdapter(List<NoteEntity> list, OnUserClickListener onUserClickListener){
        noteList=list;
        this.onUserClickListener= this.onUserClickListener;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textName;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textName=itemView.findViewById(R.id.textItem);
            itemView.setOnClickListener(this);
        }
        void bind(NoteEntity note){
            textName.setText(note.getName());
        }

        @Override
        public void onClick(View v) {
            NoteEntity noteEntity=noteList.get(getLayoutPosition());
            onUserClickListener.onUserClick(noteEntity);
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bind(noteList.get(position));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
    interface OnUserClickListener{
        void onUserClick(NoteEntity noteEntity);
    }
}
