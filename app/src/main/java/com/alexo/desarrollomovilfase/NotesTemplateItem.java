package com.alexo.desarrollomovilfase;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotesTemplateItem extends RecyclerView.ViewHolder {
    public TextView itemTitle, itemDate, itemDesc;
    public NotesTemplateItem(@NonNull View itemView) {
        super(itemView);
        itemTitle = itemView.findViewById(R.id.rvNotesTitle);
        itemDate = itemView.findViewById(R.id.rvNotesDate);
        itemDesc = itemView.findViewById(R.id.rvNotesDesc);

    }
}