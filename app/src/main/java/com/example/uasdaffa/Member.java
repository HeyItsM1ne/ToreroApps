package com.example.uasdaffa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.os.Bundle;

public class Member extends AppCompatActivity {

    ListView lst;

    String[] NamaTim = {"Torero Nine", "Torero Senja"};//, "Torero SkyDreams", "Torero Eliminate", "Torero ART", "Torero Phantom";
    String[] Pemain = {"TRR9ZiGOD\nTRR9Heero\nTRR9AL4TREON\nTRR9Craving", "TRRSTinker\nTRRSStevZx\nTRRSZorn\nTRRSBAD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        ListView list = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> myAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Pemain);

        list.setAdapter(myAdapter);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    //public void oprek(View view) {
      //  switch (view.getId()) {
        //    case R.id.oprek:
          //      startActivity(new Intent(this, Oprek.class));
          //      break;
        //}
    }

//    public boolean onSupportNavigateUp() {
  //      finish();
        //return true;
 //   }

//    public void onClick(View view) {
  //      switch (view.getId()) {
    //        case R.id.oprek:
      //          startActivity(new Intent(this, Oprek.class));
        //        break;
        //}
