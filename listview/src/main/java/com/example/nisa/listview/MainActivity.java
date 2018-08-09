package com.example.nisa.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nisa.listview.fragments.FirstFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemLongClickListener, FirstFragment.OnSubmitButtonListener {

    ListView listView;
    EditText inputNameET;
    Button addButton;
    ArrayList<String> listNama = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.add_button);
        inputNameET = findViewById(R.id.input_name_edittext);

        listView = findViewById(R.id.listview);
        listNama.add("Anisa");
        listNama.add("Shinta");
        listNama.add("Sasa");
        listNama.add("Icha");

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listNama);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemLongClickListener(this);
        addButton.setOnClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, listNama.get(position), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_button:
                if (!inputNameET.getText().toString().equalsIgnoreCase("")) {
                    listNama.add(inputNameET.getText().toString());
                    inputNameET.setText("");
                    arrayAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getApplicationContext(), "Isikan Nama", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        FirstFragment firstFragment = FirstFragment.newInstance(listNama.get(position), position);
        firstFragment.show(getSupportFragmentManager(), "");
        return false;
    }

    @Override
    public void onSubmitButton(String nama, int position) {
        listNama.set(position, nama);
        arrayAdapter.notifyDataSetChanged();

    }
}
