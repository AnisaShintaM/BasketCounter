package com.example.nisa.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.nisa.listview.model.Person;

public class SecondActivity extends AppCompatActivity {

    TextView namaTV, alamatTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        namaTV = findViewById(R.id.name_textview);
        alamatTV = findViewById(R.id.address_textview);

        if (getIntent().getExtras() != null) {

            Person person = getIntent().getExtras().getParcelable("person");
            namaTV.setText(person.getName());
            alamatTV.setText(person.getAddress());
        }
    }
}
