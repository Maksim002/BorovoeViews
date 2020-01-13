package com.timelysoft.borovoe.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.adapters.ImageViewPagerAdapter;
import com.timelysoft.borovoe.adapters.RoomsExpListAdapter;
import com.timelysoft.borovoe.custom.ExpandableTextView;
import com.timelysoft.borovoe.model.RoomsDataPumpFacilities;
import com.timelysoft.borovoe.model.RoomsDataPumpRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Rooms extends AppCompatActivity {

    private ExpandableTextView description;
    private ViewPager imageViewPager;
    private TabLayout tabLayout;
    private ImageViewPagerAdapter pagerAdapter;

    private List<String> urls;

    private RoomsExpListAdapter adapter;

    private ExpandableListView expandableListViewFaclities;
    private ExpandableListView expandableListViewRules;

    private HashMap<String, List<String>> expandableListDetailFacilities;
    private HashMap<String, List<String>> expandableListDetailRules;

    private List<String> expandableListTitleFacilities;
    private List<String> expandableListTitleRules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        setToolbar();
        init();
        initExpandableFaclities();
        initExpandableRules();
    }


    private void initExpandableFaclities() {
        expandableListViewFaclities = findViewById(R.id.rooms_expandablelistview_facilities);
        expandableListDetailFacilities = RoomsDataPumpFacilities.getData();
        expandableListTitleFacilities = new ArrayList<String>(expandableListDetailFacilities.keySet());

        adapter = new RoomsExpListAdapter(this, expandableListTitleFacilities, expandableListDetailFacilities);

        expandableListViewFaclities.setAdapter(adapter);

        expandableListViewFaclities.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                setListViewHeight(parent, groupPosition);
                return false;
            }
        });

    }

    private void initExpandableRules() {
        expandableListViewRules = findViewById(R.id.rooms_expandablelistview_rules);
        expandableListDetailRules = RoomsDataPumpRules.getData();
        expandableListTitleRules = new ArrayList<String>(expandableListDetailRules.keySet());

        adapter = new RoomsExpListAdapter(this, expandableListTitleRules, expandableListDetailRules);

        expandableListViewRules.setAdapter(adapter);

        expandableListViewRules.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                setListViewHeight(parent, groupPosition);
                return false;
            }
        });

    }


    private void init() {
        description = findViewById(R.id.rooms_description_expandabletextview);
        imageViewPager = findViewById(R.id.rooms_imageviewpager);
        tabLayout = findViewById(R.id.rooms_tablayout);


        urls = new ArrayList<>();
        urls.add("https://static.tildacdn.com/tild6135-6565-4765-b230-623535366634/DSC04683.jpg");
        urls.add("https://static.tildacdn.com/tild6135-6565-4765-b230-623535366634/DSC04683.jpg");
        urls.add("https://static.tildacdn.com/tild6135-6565-4765-b230-623535366634/DSC04683.jpg");
        urls.add("https://static.tildacdn.com/tild6135-6565-4765-b230-623535366634/DSC04683.jpg");
        urls.add("https://static.tildacdn.com/tild6135-6565-4765-b230-623535366634/DSC04683.jpg");
        urls.add("https://static.tildacdn.com/tild6135-6565-4765-b230-623535366634/DSC04683.jpg");
        urls.add("https://static.tildacdn.com/tild6135-6565-4765-b230-623535366634/DSC04683.jpg");


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
        RoomsExpListAdapter listAdapter = (RoomsExpListAdapter) listView.getExpandableListAdapter();
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
