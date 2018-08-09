package com.example.nisa.testcase.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nisa.testcase.R;
import com.example.nisa.testcase.utility.Constant;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MatchFragment.OnButtonNextClickedListener} interface
 * to handle interaction events.
 * Use the {@link MatchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MatchFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    int scoreTeamA, scoreTeamB;
    Button buttonPlusOneTeamA, buttonPlusTwoTeamA, buttonPlusThreeTeamA;
    Button buttonPlusOneTeamB, buttonPlusTwoTeamB, buttonPlusThreeTeamB;
    Button buttonNext;
    TextView quarterTV, teamATV, teamBTV, scoreTeamATV, scoreTeamBTV;
    // TODO: Rename and change types of parameters
    private String teamAName;
    private String teamBName;
    private int quarter;
    private OnButtonNextClickedListener mListener;

    public MatchFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MatchFragment newInstance(String teamA, String teamB, int quarter, int scoreTeamA, int scoreTeamB) {
        MatchFragment fragment = new MatchFragment();
        Bundle args = new Bundle();
        args.putString(Constant.KEY_TEAM_A_NAME, teamA);
        args.putString(Constant.KEY_TEAM_B_NAME, teamB);
        args.putInt(Constant.KEY_QUARTER, quarter);
        args.putInt(Constant.KEY_SCORE_TEAM_A, scoreTeamA);
        args.putInt(Constant.KEY_SCORE_TEAM_B, scoreTeamB);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            teamAName = getArguments().getString(Constant.KEY_TEAM_A_NAME);
            teamBName = getArguments().getString(Constant.KEY_TEAM_B_NAME);
            quarter = getArguments().getInt(Constant.KEY_QUARTER);
            scoreTeamA = getArguments().getInt(Constant.KEY_SCORE_TEAM_A);
            scoreTeamB = getArguments().getInt(Constant.KEY_SCORE_TEAM_B);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match, container, false);

        buttonNext = view.findViewById(R.id.button_next);

        buttonPlusOneTeamA = view.findViewById(R.id.plus_one_teama_button);
        buttonPlusTwoTeamA = view.findViewById(R.id.plus_two_teama_button);
        buttonPlusThreeTeamA = view.findViewById(R.id.plus_three_teama_button);

        buttonPlusOneTeamB = view.findViewById(R.id.plus_one_teamb_button);
        buttonPlusTwoTeamB = view.findViewById(R.id.plus_two_teamb_button);
        buttonPlusThreeTeamB = view.findViewById(R.id.plus_three_teamb_button);

        quarterTV = view.findViewById(R.id.quarter_textview);
        teamATV = view.findViewById(R.id.teama_textview);
        teamBTV = view.findViewById(R.id.teamb_textview);
        scoreTeamATV = view.findViewById(R.id.teama_score);
        scoreTeamBTV = view.findViewById(R.id.teamb_score);

        buttonNext.setOnClickListener(this);
        buttonPlusOneTeamA.setOnClickListener(this);
        buttonPlusTwoTeamA.setOnClickListener(this);
        buttonPlusThreeTeamA.setOnClickListener(this);
        buttonPlusOneTeamB.setOnClickListener(this);
        buttonPlusTwoTeamB.setOnClickListener(this);
        buttonPlusThreeTeamB.setOnClickListener(this);

        switch (quarter) {
            case 1:
                quarterTV.setText("1st");
                break;

            case 2:
                quarterTV.setText("2nd");
                break;

            case 3:
                quarterTV.setText("3rd");
                break;

            case 4:
                quarterTV.setText("4th");
                break;

        }

        teamATV.setText(teamAName);
        teamBTV.setText(teamBName);

        scoreTeamATV.setText(scoreTeamA + "");
        scoreTeamBTV.setText(scoreTeamB + "");
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onButtonNextClicked(0,0);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnButtonNextClickedListener) {
            mListener = (OnButtonNextClickedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plus_one_teama_button:
                scoreTeamA += 1;
                break;

            case R.id.plus_two_teama_button:
                scoreTeamA += 2;
                break;

            case R.id.plus_three_teama_button:
                scoreTeamA += 3;
                break;

            case R.id.plus_one_teamb_button:
                scoreTeamB += 1;
                break;

            case R.id.plus_two_teamb_button:
                scoreTeamB += 2;
                break;

            case R.id.plus_three_teamb_button:
                scoreTeamB += 3;
                break;

            case R.id.button_next:
                mListener.onButtonNextClicked(scoreTeamA, scoreTeamB);
                getActivity().getSupportFragmentManager().popBackStack();
                break;
        }

        scoreTeamATV.setText(scoreTeamA + "");
        scoreTeamBTV.setText(scoreTeamB + "");

    }

    public interface OnButtonNextClickedListener {
        // TODO: Update argument type and name
        void onButtonNextClicked(int scoreTeamA, int scoreTeamB);

    }
}
