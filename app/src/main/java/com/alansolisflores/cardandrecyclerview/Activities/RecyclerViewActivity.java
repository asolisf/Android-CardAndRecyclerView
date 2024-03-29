package com.alansolisflores.cardandrecyclerview.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.alansolisflores.cardandrecyclerview.Adapters.MyAdapter;
import com.alansolisflores.cardandrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    private RecyclerView recyclerView;

    private List<String> names;

    private RecyclerView.Adapter adapter;

    private RecyclerView.LayoutManager layoutManager;

    private int added;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.names = getNames();
        this.added = 1;

        this.recyclerView = findViewById(R.id.namesRecyclerView);

        //In line
        this.layoutManager = new LinearLayoutManager(this);

        //Grid with span count
        this.layoutManager = new GridLayoutManager(this,2);

        // Looks like grid layout but with different width items
        this.layoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);

        this.adapter = new MyAdapter(names,
                                     R.layout.recycler_view_item,
                     this);

        //If layout doesn't change. Doesn't use with StaggeredManager
        this.recyclerView.setHasFixedSize(true);

        //Default animation
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.addItemDecoration(new DividerItemDecoration(RecyclerViewActivity.this,
                                                                DividerItemDecoration.VERTICAL));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_name:
                this.addName(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<String> getNames(){
        return new ArrayList<String>(){{
           add("Alan");
           add("Eduardo");
           add("Angel");
           add("Andrea");
        }};
    }

    private void addName(int position){
        this.names.add(position,"New name "+(this.added++));
        this.adapter.notifyItemInserted(position);
        this.recyclerView.scrollToPosition(position);
    }

    private void removeName(int position){
        this.names.remove(position);
        this.adapter.notifyItemRemoved(position);
    }

    @Override
    public void onItemClick(String name, int position) {
        this.removeName(position);
    }
}
