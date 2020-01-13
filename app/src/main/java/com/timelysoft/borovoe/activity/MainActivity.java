package com.timelysoft.borovoe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.fragments.BookingRoomsBusy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newsOnCicked(View view) {
        Intent intent = new Intent(this, News.class);
        startActivity(intent);
    }

    public void discountOnCicked(View view) {
        Intent intent = new Intent(this, Discounts.class);
        startActivity(intent);
    }

    public void intertainmentOnClicked (View view){
        Intent intent = new Intent(this, Intertainment.class);
        startActivity(intent);
    }

    public void mainMenuOnClicked (View view){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void roomsOnClicked (View view){
        Intent intent = new Intent(this, Rooms.class);
        startActivity(intent);
    }

    public void bookingOnClicked(View view) {
        Intent intent = new Intent(this, Booking.class);
        startActivity(intent);
    }

    public void alertOnClicked(View view) {
        BookingRoomsBusy exampleDialog = new BookingRoomsBusy();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
    public void reviewsOnClicked(View view) {
        Intent intent = new Intent(this, Reviews.class);
        startActivity(intent);
    }

}
