package com.example.greggnicholas.bookrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private final Context context;
    private List<Book> data;
    private LayoutInflater inflater;


    public RecyclerViewAdapter(Context context, List<Book> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        View view;
        view = inflater.inflate(R.layout.cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.textViewBook.setText(data.get(position).getTitle());
        myViewHolder.imageViewThumbnail.setImageResource(data.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewBook;
        ImageView imageViewThumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewBook = itemView.findViewById(R.id.book_title);
            imageViewThumbnail = itemView.findViewById(R.id.book_image);

        }


    }
}
