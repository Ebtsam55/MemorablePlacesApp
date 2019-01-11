package com.example.ebtsam.memorableplacesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    static ArrayList<String> places;
    static  ArrayList<LatLng>location;
   static ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list_view);
        places=new ArrayList<>();
        location=new ArrayList<>();
        places.add("Add a new place...");
        location.add(new LatLng(0,0));
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,places);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (MainActivity.this ,MapsActivity.class);
                intent.putExtra("placeNumber",position);
                startActivity(intent);
            }
        });


    }
}
