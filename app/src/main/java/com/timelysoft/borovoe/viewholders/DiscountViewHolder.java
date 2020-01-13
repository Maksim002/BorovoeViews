package com.timelysoft.borovoe.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.interfaces.ClickListener;
import com.timelysoft.borovoe.model.DiscountModels;

public class DiscountViewHolder extends RecyclerView.ViewHolder {
    private ClickListener listener;
    private ImageView imageView;
    private TextView title;
    private TextView content;

    public DiscountViewHolder(@NonNull View itemView, ClickListener listener) {
        super(itemView);
        imageView = itemView.findViewById(R.id.discount_detail_imageview);
        title = itemView.findViewById(R.id.discount_detail_title);
        content = itemView.findViewById(R.id.discount_detail_content);
        this.listener = listener;
    }

    public void bind(final DiscountModels item) {
        Glide.with(itemView)
                .load(item.getImagePath())
                .into(imageView);

        title.setText(item.getTitle());
        content.setText(item.getContent());


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClickItemListener(item);
            }
        });

    }


}

