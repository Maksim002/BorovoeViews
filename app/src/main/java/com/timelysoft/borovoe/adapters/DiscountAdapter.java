package com.timelysoft.borovoe.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.interfaces.ClickListener;
import com.timelysoft.borovoe.model.DiscountModels;
import com.timelysoft.borovoe.viewholders.DiscountViewHolder;

import java.util.ArrayList;

public class DiscountAdapter extends RecyclerView.Adapter<DiscountViewHolder> {

    private ArrayList<DiscountModels> list;
    private ClickListener listener;

    public DiscountAdapter(ArrayList<DiscountModels> list, ClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DiscountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_discount, parent, false);
        return new DiscountViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    private DiscountModels getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
