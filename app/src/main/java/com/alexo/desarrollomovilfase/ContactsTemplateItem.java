package com.alexo.desarrollomovilfase;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsTemplateItem extends RecyclerView.ViewHolder {
    public TextView itemName, itemLastName, itemPhone, itemEmail, itemNotes;
    public ContactsTemplateItem(@NonNull View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.rvName);
        itemLastName = itemView.findViewById(R.id.rvLastName);
        itemPhone = itemView.findViewById(R.id.rvPhone);
        itemEmail = itemView.findViewById(R.id.rvEmail);
        itemNotes = itemView.findViewById(R.id.rvNotes);

    }
}
