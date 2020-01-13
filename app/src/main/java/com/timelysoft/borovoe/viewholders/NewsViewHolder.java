package com.timelysoft.borovoe.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.custom.ExpandableTextView;
import com.timelysoft.borovoe.model.NewsModels;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    private ImageView firstImageView;
    private ImageView secondImageView;
    private ImageView thirdImageView;
    private ImageView fourthImageView;

    private TextView title;
    private ExpandableTextView content;
    private TextView date;


    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        firstImageView = itemView.findViewById(R.id.news_example1_imageview);
        secondImageView = itemView.findViewById(R.id.news_example2_imageview);
        thirdImageView = itemView.findViewById(R.id.news_example3_imageview);
        fourthImageView = itemView.findViewById(R.id.news_example4_imageview);

        title = itemView.findViewById(R.id.news_title_textview);
        content = itemView.findViewById(R.id.news_content_textview);
        date = itemView.findViewById(R.id.news_date_textview);
    }

    public void bind(NewsModels item) {
        Glide.with(itemView)
                .load(item.getFirstImage())
                .into(firstImageView);


        Glide.with(itemView)
                .load(item.getSecondImage())
                .into(secondImageView);


        Glide.with(itemView)
                .load(item.getThirdImage())
                .into(thirdImageView);


        Glide.with(itemView)
                .load(item.getFourthImage())
                .into(fourthImageView);

        title.setText(item.getTitle());
        content.setTrimLength(5);
        content.setText(item.getContent(), TextView.BufferType.NORMAL);
        date.setText(item.getData());
    }
}
