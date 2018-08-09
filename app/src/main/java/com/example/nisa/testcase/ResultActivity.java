package com.example.nisa.testcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nisa.testcase.utility.Constant;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBack;
    TextView winnerTV, scoreTV;
    String winnerTeam;
    int scoreWinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        winnerTV = findViewById(R.id.winner_team_textview);
        scoreTV = findViewById(R.id.winner_team_score);
        btnBack = findViewById(R.id.backbutton);
        btnBack.setOnClickListener(this);

        if (getIntent().getExtras() != null) {
            winnerTeam = getIntent().getExtras().getString(Constant.KEY_WINNER_TEAM);
            scoreWinner = getIntent().getExtras().getInt(Constant.KEY_WINNER_SCORE);
        }
        winnerTV.setText(winnerTeam + "");
        scoreTV.setText(scoreWinner + "");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }

    }
}
