package com.timelysoft.borovoe.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.interfaces.ClickListener;
import com.timelysoft.borovoe.model.IntertainmentModel;
import com.timelysoft.borovoe.viewholders.IntertaimViewHolder;

import java.util.ArrayList;

public class IntertaimAdapter extends RecyclerView.Adapter<IntertaimViewHolder>{

    private ArrayList<IntertainmentModel> list;
    private ClickListener listener;

    public IntertaimAdapter(ArrayList<IntertainmentModel> list, ClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public IntertaimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_intertain, parent, false);
        return new IntertaimViewHolder(view, listener);
    }


    @Override
    public void onBindViewHolder(@NonNull IntertaimViewHolder holder, int position) {
        holder.bind(getItem(position));

    }

    private IntertainmentModel getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
