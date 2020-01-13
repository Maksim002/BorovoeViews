package com.timelysoft.borovoe.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.interfaces.ClickListener;
import com.timelysoft.borovoe.model.IntertainmentModel;

public class IntertaimViewHolder extends RecyclerView.ViewHolder {
    private ClickListener listener;
    private ImageView intertainImageView;
    private TextView intertainTextView;
    private ImageView intertainDrawable;

    public IntertaimViewHolder(@NonNull View itemView, ClickListener listener) {
        super(itemView);
        this.listener = listener;
        intertainImageView = itemView.findViewById(R.id.intertainment_imageview);
        intertainTextView = itemView.findViewById(R.id.intertainment_textview);
        intertainDrawable = itemView.findViewById(R.id.intertainment_drawable);

    }

    public void bind(final IntertainmentModel item) {
        Glide.with(itemView)
                .load(item.getImagePath())
                .into(intertainImageView);

        intertainTextView.setText(item.getTitle());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClickItemListener(item);
            }
        });
    }


}
