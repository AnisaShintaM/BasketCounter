package com.example.nisa.testcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.nisa.testcase.fragments.MatchFragment;
import com.example.nisa.testcase.utility.Constant;

public class MatchActivity extends AppCompatActivity implements MatchFragment.OnButtonNextClickedListener {
    String teamAName, teamBName;
    int quarter = 1;
    int scoreTeamA = 0, scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        if (getIntent().getExtras() != null) {
            teamAName = getIntent().getExtras().getString(Constant.KEY_TEAM_A_NAME);
            teamBName = getIntent().getExtras().getString(Constant.KEY_TEAM_B_NAME);
        }

        loadFragment();
    }

    @Override
    public void onButtonNextClicked(int scoreTeamA, int scoreTeamB) {
        this.scoreTeamA = scoreTeamA;
        this.scoreTeamB = scoreTeamB;

        ++quarter;
        if (quarter <= 4) {
            loadFragment();
        } else {
            Intent intent = new Intent(this, ResultActivity.class);
            int scoreWinner = 0;
            String winnerTeam;

            if (scoreTeamA > scoreTeamB) {
                scoreWinner = scoreTeamA;
                winnerTeam = teamAName;
            } else if (scoreTeamA < scoreTeamB) {
                scoreWinner = scoreTeamB;
                winnerTeam = teamBName;
            } else {
                winnerTeam = "DRAW";
            }

            intent.putExtra(Constant.KEY_WINNER_TEAM, winnerTeam);
            intent.putExtra(Constant.KEY_WINNER_SCORE, scoreWinner);
            startActivity(intent);
        }

        // quarter++;

    }

    private void loadFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MatchFragment matchFragment = MatchFragment.newInstance(teamAName, teamBName, quarter, scoreTeamA, scoreTeamB);
        transaction.add(R.id.fragment_container, matchFragment);
        transaction.commit();
    }
}
