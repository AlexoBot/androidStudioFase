package com.alexo.desarrollomovilfase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesRVAdapter extends RecyclerView.Adapter <NotesTemplateItem>{
    private final Context context;
    ArrayList<NotesModel> lista;
    public NotesRVAdapter(ArrayList<NotesModel> lista, Context context){
        this.lista = lista;
        this.context = context;
    }
    @NonNull
    @Override
    public NotesTemplateItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_rv_item,parent,false);
        return new NotesTemplateItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesTemplateItem holder, int position) {
        NotesModel model = lista.get(position);

        holder.itemTitle.setText(model.getTitle());
        holder.itemDate.setText(model.getDate());
        holder.itemDesc.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {return lista.size();}
}
