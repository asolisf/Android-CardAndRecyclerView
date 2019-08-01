package com.alansolisflores.cardandrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> names;

    private int layout;

    private OnItemClickListener onItemClickListener;

    public MyAdapter(List<String> names,int layout, OnItemClickListener onItemClickListener){
        this.names = names;
        this.layout = layout;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind(names.get(i),onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    /**
     * View holder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(View view){
            super(view);
            this.name = view.findViewById(R.id.nameTextView);
        }

        public void bind(final String name,final OnItemClickListener onItemClickListener){
            this.name.setText(name);

            //Set own listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(name,getAdapterPosition());
                }
            });
        }
    }

    /**
     * Custom on item click listener interface
     */
    public interface OnItemClickListener{
        void onItemClick(String name,int position);
    }
}
