package com.example.re_contactroom2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.re_contactroom2.Model.Contact;
import com.example.re_contactroom2.Model.ContactViewModel;
import com.example.re_contactroom2.R;
import com.example.re_contactroom2.RecycleView.RecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ContactViewModel contactViewModel;
    private FloatingActionButton floatButton;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        floatButton = findViewById(R.id.floatingActionButton);

        contactViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this
                .getApplication()).create(ContactViewModel.class);


        // this is where we are using the great feature of livedata and observind and reporting stuff
        contactViewModel.getAllContact().observe(this, contacts -> {

            // set up adapter
            recyclerViewAdapter = new RecyclerViewAdapter(contacts,MainActivity.this);
            recyclerView.setAdapter(recyclerViewAdapter);


        floatButton.setOnClickListener(v1 -> {
            Intent intent = new Intent(MainActivity.this, CreateContact.class);
            startActivity(intent);});



            });
    }
}