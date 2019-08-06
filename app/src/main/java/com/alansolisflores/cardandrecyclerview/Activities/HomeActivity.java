package com.alansolisflores.cardandrecyclerview.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.alansolisflores.cardandrecyclerview.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()){
            case R.id.recyclerViewItem:
                intent = new Intent(HomeActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
                return true;
            case R.id.cardViewItem:
                intent = new Intent(HomeActivity.this,CardViewActivity.class);
                startActivity(intent);
                return true;
            case R.id.cardViewAndRecyclerItem:
                intent = new Intent(HomeActivity.this,CardAndRecyclerActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
