package com.timelysoft.borovoe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.model.DiscountModels;

public class DiscountsDetail extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView discountImageView;
    private TextView discountTitleTextView;
    private TextView discountContentTextView;
    private TextView discountAdTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_discount);
        findByID();
        setToolbar();
        setData();
    }

    private void findByID() {
        discountImageView = findViewById(R.id.discount_detail_imageview);
        discountAdTextView = findViewById(R.id.discount_detail_ad_textview);
        discountTitleTextView = findViewById(R.id.discount_detail_title);
        discountContentTextView = findViewById(R.id.discount_detail_content);
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
    }

    private void setData() {
        Intent intent = getIntent();
        DiscountModels models = intent.getParcelableExtra("start");

        Glide.with(this)
                .load(models.getImagePath())
                .into(discountImageView);

        discountAdTextView.setText(models.getAdContent());
        discountContentTextView.setText(models.getContent());
        discountTitleTextView.setText(models.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

}
