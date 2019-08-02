package com.alansolisflores.cardandrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CardAndRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_and_recycler);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
