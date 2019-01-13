package com.example.greggnicholas.bookrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final String BASE_API = "https://api.gettyimages.com/v3/";
    List<Book> book;
    ImageView imageView;

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.book_image);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        retrofit.create(BookService.class)


        book = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(this, book);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
    }
}
