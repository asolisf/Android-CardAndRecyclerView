package com.alansolisflores.cardandrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    private RecyclerView recyclerView;

    private List<String> names;

    private RecyclerView.Adapter adapter;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.names = getNames();

        this.recyclerView = findViewById(R.id.namesRecyclerView);
        this.layoutManager = new LinearLayoutManager(this);
        this.adapter = new MyAdapter(names,
                                     R.layout.recycler_view_item,
                     this);

        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setAdapter(this.adapter);
    }

    private List<String> getNames(){
        return new ArrayList<String>(){{
           add("Alan");
           add("Eduardo");
           add("Angel");
           add("Andrea");
        }};
    }

    @Override
    public void onItemClick(String name, int posistion) {
        Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
    }
}
