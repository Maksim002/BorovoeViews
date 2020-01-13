package com.timelysoft.borovoe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.adapters.DiscountAdapter;
import com.timelysoft.borovoe.interfaces.ClickListener;
import com.timelysoft.borovoe.model.DiscountModels;
import com.timelysoft.borovoe.model.IntertainmentModel;

import java.util.ArrayList;

public class Discounts extends AppCompatActivity implements ClickListener {
    private ArrayList<DiscountModels> list;
    private RecyclerView recyclerView;
    private DiscountAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_discounts);
        super.onCreate(savedInstanceState);
        setToolbar();
        recyclerView = findViewById(R.id.discount_recyclerview);
        getDiscounts();
        adapter = new DiscountAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }

    private void setToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
    }

    private void getDiscounts() {
        list = new ArrayList<>();
        list.add(new DiscountModels(getString(R.string.discount_image_path), getString(R.string.discount_title), getString(R.string.discount_content), getString(R.string.ad_content_string)));
        list.add(new DiscountModels(getString(R.string.discount_image_path), getString(R.string.discount_title), getString(R.string.discount_content), getString(R.string.ad_content_string)));
        list.add(new DiscountModels(getString(R.string.discount_image_path), getString(R.string.discount_title), getString(R.string.discount_content), getString(R.string.ad_content_string)));
        list.add(new DiscountModels(getString(R.string.discount_image_path), getString(R.string.discount_title), getString(R.string.discount_content), getString(R.string.ad_content_string)));
        list.add(new DiscountModels(getString(R.string.discount_image_path), getString(R.string.discount_title), getString(R.string.discount_content), getString(R.string.ad_content_string)));
        list.add(new DiscountModels(getString(R.string.discount_image_path), getString(R.string.discount_title), getString(R.string.discount_content), getString(R.string.ad_content_string)));
        list.add(new DiscountModels(getString(R.string.discount_image_path), getString(R.string.discount_title), getString(R.string.discount_content), getString(R.string.ad_content_string)));
        list.add(new DiscountModels(getString(R.string.discount_image_path), getString(R.string.discount_title), getString(R.string.discount_content), getString(R.string.ad_content_string)));
        list.add(new DiscountModels(getString(R.string.discount_image_path), getString(R.string.discount_title), getString(R.string.discount_content), getString(R.string.ad_content_string)));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnClickItemListener(DiscountModels discountModels) {
        Intent intent = new Intent(this, DiscountsDetail.class);
        intent.putExtra("start", discountModels);
        startActivity(intent);
    }

    @Override
    public void OnClickItemListener(IntertainmentModel intertaimModel) {

    }


}
