package com.alansolisflores.cardandrecyclerview.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alansolisflores.cardandrecyclerview.Adapters.CardViewAdapter;
import com.alansolisflores.cardandrecyclerview.Models.Movie;
import com.alansolisflores.cardandrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class CardAndRecyclerActivity extends AppCompatActivity implements CardViewAdapter.OnItemClickListener {

    private List<Movie> movies;

    private RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;

    private CardViewAdapter cardViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_and_recycler);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getMovies();

        recyclerView = findViewById(R.id.cardRecyclerView);

        this.linearLayoutManager = new LinearLayoutManager(this);
        this.cardViewAdapter
                = new CardViewAdapter(
                        movies,
                        R.layout.card_view_recycler,CardAndRecyclerActivity.this);

        this.recyclerView.setLayoutManager(this.linearLayoutManager);
        this.recyclerView.setAdapter(this.cardViewAdapter);
    }

    @Override
    public void onItemClick(Movie movie, int position) {
        Toast.makeText(CardAndRecyclerActivity.this,movie.getName(),Toast.LENGTH_SHORT)
                .show();
    }

    private void getMovies(){
        movies = new ArrayList<Movie>(){{
            add(new Movie("Once upon a time in Hollywood",R.drawable.once_upon));
            add(new Movie("Detective pickachu",R.drawable.detective_pickachu));
            add(new Movie("Endgame",R.drawable.endgame));
            add(new Movie("Deadpool",R.drawable.deadpool));
        }};
    }
}
