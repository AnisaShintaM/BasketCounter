package com.example.nisa.testcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nisa.testcase.utility.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonStart;
    EditText teamAET, teamBET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.button_start);
        teamAET = findViewById(R.id.teama_edittext);
        teamBET = findViewById(R.id.teamb_edittext);

        buttonStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_start:
                if (validate()) {
                    Intent intent = new Intent(this, MatchActivity.class);
                    intent.putExtra(Constant.KEY_TEAM_A_NAME, teamAET.getText().toString());
                    intent.putExtra(Constant.KEY_TEAM_B_NAME, teamBET.getText().toString());
                    startActivity(intent);
                }
                break;
        }
    }

    public boolean validate() {
        if (TextUtils.isEmpty(teamAET.getText().toString()) || TextUtils.isEmpty(teamBET.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Nama Team Harus Diisi", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (teamAET.getText().toString().equalsIgnoreCase(teamBET.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Nama Team Tidak Boleh Sama", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
