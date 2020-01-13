package com.timelysoft.borovoe.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.adapters.ImageViewPagerAdapter;
import com.timelysoft.borovoe.adapters.IntertainExpListAdapter;
import com.timelysoft.borovoe.custom.ExpandableTextView;
import com.timelysoft.borovoe.model.IntertainmentListDataPump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntertainDetail extends AppCompatActivity {
    private ExpandableTextView description;
    private ViewPager imageViewPager;
    private TabLayout tabLayout;
    private ImageViewPagerAdapter pagerAdapter;
    private List<String> urls;
    private ExpandableListView expandableListView;
    private HashMap<String, List<String>> expandableListDetail;
    private List<String> expandableListTitle;
    private IntertainExpListAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_intertain);
        init();
        initExpandable();
        setToolbar();
    }

    private void initExpandable() {
        expandableListView = findViewById(R.id.intertain_detail_expandablelistview);
        expandableListDetail = IntertainmentListDataPump.getData();
        expandableListTitle =  new ArrayList<String>(expandableListDetail.keySet());

        adapter = new IntertainExpListAdapter(this, expandableListTitle, expandableListDetail);

        expandableListView.setAdapter(adapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                setListViewHeight(parent, groupPosition);
                return false;
            }
        });

    }


    private void init() {
        description = findViewById(R.id.intertain_detail_description_expandabletextview);
        imageViewPager = findViewById(R.id.intertain_detail_imageviewpager);
        tabLayout = findViewById(R.id.intertain_detail_tablayout);


        urls = new ArrayList<>();
        urls.add("https://r-cf.bstatic.com/images/hotel/max1024x768/132/132746578.jpg");
        urls.add("https://r-cf.bstatic.com/images/hotel/max1024x768/132/132746578.jpg");
        urls.add("https://r-cf.bstatic.com/images/hotel/max1024x768/132/132746578.jpg");
        urls.add("https://r-cf.bstatic.com/images/hotel/max1024x768/132/132746578.jpg");
        urls.add("https://r-cf.bstatic.com/images/hotel/max1024x768/132/132746578.jpg");

        pagerAdapter = new ImageViewPagerAdapter(this, urls);
        imageViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(imageViewPager, true);


        description.setTrimLength(5);
        description.setText(getString(R.string.content_tools), TextView.BufferType.NORMAL);
    }


    private void setToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }



    private void setListViewHeight(ExpandableListView listView, int group) {
        IntertainExpListAdapter listAdapter = (IntertainExpListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }

}
