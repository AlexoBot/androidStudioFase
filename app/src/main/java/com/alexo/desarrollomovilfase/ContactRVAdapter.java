package com.alexo.desarrollomovilfase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactRVAdapter extends RecyclerView.Adapter<ContactsTemplateItem> {
    ArrayList<ContactsModel> lista;
    private Context context;
    public ContactRVAdapter(ArrayList<ContactsModel> lista, Context context){
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactsTemplateItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_rv_item,parent,false);
        return new ContactsTemplateItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsTemplateItem holder, int position) {
        ContactsModel model = lista.get(position);

        holder.itemName.setText(model.getName());
        holder.itemLastName.setText(model.getLastName());
        holder.itemPhone.setText(model.getPhone());
        holder.itemEmail.setText(model.getEmail());
        holder.itemNotes.setText(model.getNotes());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
