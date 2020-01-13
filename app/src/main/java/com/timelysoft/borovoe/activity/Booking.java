package com.timelysoft.borovoe.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.timelysoft.borovoe.R;
import com.timelysoft.borovoe.fragments.BookingAcceptAction;

public class Booking extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        button = findViewById(R.id.booking_buy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookingAcceptAction acceptActionFragment =
                        BookingAcceptAction.newInstance();
                acceptActionFragment.show(getSupportFragmentManager(),
                        BookingAcceptAction.TAG);
            }
        });
    }

}
