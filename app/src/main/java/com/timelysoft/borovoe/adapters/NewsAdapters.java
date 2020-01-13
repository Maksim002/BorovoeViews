package com.timelysoft.borovoe.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.model.NewsModels;
import com.timelysoft.borovoe.viewholders.NewsViewHolder;

import java.util.ArrayList;

public class NewsAdapters extends RecyclerView.Adapter<NewsViewHolder> {

    private ArrayList<NewsModels> list;

    public NewsAdapters(ArrayList<NewsModels> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    private NewsModels getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
