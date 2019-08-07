package com.alansolisflores.cardandrecyclerview.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alansolisflores.cardandrecyclerview.Models.Movie;
import com.alansolisflores.cardandrecyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {

    private List<Movie> movies;

    private int layout;

    private OnItemClickListener onItemClickListener;

    public CardViewAdapter(List<Movie> movies,
                           int layout,
                           OnItemClickListener onItemClickListener){
        this.movies = movies;
        this.layout = layout;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.bind(movies.get(position),this.onItemClickListener, position);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        private ImageView imageView;

        public ViewHolder(View view){
            super(view);

            this.textView = view.findViewById(R.id.textCardViewRecycler);
            this.imageView = view.findViewById(R.id.imageCardViewRecycler);
        }

        public void bind(final Movie movie, final OnItemClickListener onItemClickListener, final int position){
            this.textView.setText(movie.getName());


            Picasso.get()
                    .load(movie.getImage())
                    .fit()
                    .centerCrop()
                    .into(this.imageView);

            //this.imageView.setImageResource(movie.getImage());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(movie,position);
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Movie movie, int position);
    }
}
