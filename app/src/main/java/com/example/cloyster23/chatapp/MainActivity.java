package com.example.cloyster23.chatapp;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.cloyster23.chatapp.R.id.fabNyMld;

public class MainActivity extends Activity {
    ArrayAdapter<String> adapter;
    ListView listView;
    Toolbar toolbar;
    private Toolbar supportActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);



        ArrayList<Kontakt> arrayOfKontakt = new ArrayList<Kontakt>();
        Kontakt kontakt1 = new Kontakt("Jon");
        Kontakt kontakt2 = new Kontakt("Didrik");
        Kontakt kontakt3 = new Kontakt("Thom");

        arrayOfKontakt.add(kontakt1);
        arrayOfKontakt.add(kontakt2);
        arrayOfKontakt.add(kontakt3);

        kontaktAdapter kontAdapter = new kontaktAdapter(this, arrayOfKontakt);
        ListView listView = (ListView) findViewById(R.id.lvContacts);
        listView.setAdapter(kontAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Kontakt kontakt = (Kontakt) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this, SamtaleActivity.class);
                intent.putExtra("Kontakt", kontakt.getUsername());
                startActivity(intent);
            }
        });
        FloatingActionButton fabNyMld = (FloatingActionButton) findViewById(R.id.fabNyMld);
        fabNyMld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NyMeldingActivity.class);
                startActivity(intent);
            }
        });
    }
}
