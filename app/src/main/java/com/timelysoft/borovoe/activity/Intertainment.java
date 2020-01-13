package com.timelysoft.borovoe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.adapters.IntertaimAdapter;
import com.timelysoft.borovoe.interfaces.ClickListener;
import com.timelysoft.borovoe.model.DiscountModels;
import com.timelysoft.borovoe.model.IntertainmentModel;

import java.util.ArrayList;

public class Intertainment extends AppCompatActivity implements ClickListener {
    private RecyclerView recyclerView;
    private IntertaimAdapter adapter;
    private ArrayList<IntertainmentModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar();
        setContentView(R.layout.activity_intertain);
        getSupportActionBar().setTitle("Развлечение");
        addDatatoList();
        initObjects();
    }

    private void setToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
    }

    private void initObjects() {
        adapter = new IntertaimAdapter(list, this);
        recyclerView = findViewById(R.id.intertainment_recyclerview);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnClickItemListener(DiscountModels discountModels) {

    }

    @Override
    public void OnClickItemListener(IntertainmentModel intertaimModel) {
        Intent intent = new Intent(this, IntertainDetail.class);
        intent.putExtra("start", intertaimModel);
        startActivity(intent);
    }

    private void addDatatoList() {
        list = new ArrayList<>();
        list.add(new IntertainmentModel("https://i.pinimg.com/originals/0d/30/7f/0d307fbba81f6d5bf4a37275be51d0d7.jpg", "Русская баня"));
        list.add(new IntertainmentModel("https://ramzestour.com/wp-content/uploads/2019/07/foro-ekskursii-sharm-tureckaya-banya.jpg", "Турецкая баня хамам"));
        list.add(new IntertainmentModel("http://infospektr.ru/wp-content/uploads/2017/06/Vanny-i-Spa-bassejny-dzhakuzi-polza-ochevidna.jpg", "Джакузи"));
        list.add(new IntertainmentModel("https://kuyalnik.com/wp-content/uploads/2018/08/Dush-SHarko.jpg", "Душ шарко"));
        list.add(new IntertainmentModel("https://discovery-borovoe.kz/sites/default/files/spa_foto_9_0.jpg", "Шунгитово травяная баня"));
        list.add(new IntertainmentModel("https://chm-b.com/wp-content/uploads/2019/08/2e260aded9f999880f5ab8d2700a323b-375x250.jpg", "Соляная вода"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

}
