package com.timelysoft.borovoe.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.adapters.NewsAdapters;
import com.timelysoft.borovoe.model.NewsModels;

import java.util.ArrayList;

public class News extends AppCompatActivity {

    private ArrayList<NewsModels> list;
    private RecyclerView newsRecyclerView;
    private NewsAdapters adapters;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Новости");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        setContentView(R.layout.activity_news);
        newsRecyclerView = findViewById(R.id.news_recyclerview);
        getNewsList();
        adapters = new NewsAdapters(list);
        newsRecyclerView.setAdapter(adapters);
    }

    private void getNewsList() {
        list = new ArrayList<>();
        list.add(new NewsModels(getString(R.string.title_string), getString(R.string.date_string),
                getString(R.string.content_tools), getString(R.string.first_image_path), getString(R.string.first_image_path),
                getString(R.string.first_image_path), getString(R.string.first_image_path)));

        list.add(new NewsModels(getString(R.string.title_string), getString(R.string.date_string),
                getString(R.string.content_tools), getString(R.string.first_image_path), getString(R.string.first_image_path),
                getString(R.string.first_image_path), getString(R.string.first_image_path)));

        list.add(new NewsModels(getString(R.string.title_string), getString(R.string.date_string),
                getString(R.string.content_tools), "", "", "", ""));

        list.add(new NewsModels(getString(R.string.title_string), getString(R.string.date_string),
                getString(R.string.content_tools), getString(R.string.first_image_path), getString(R.string.first_image_path),
                getString(R.string.first_image_path), getString(R.string.first_image_path)));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
