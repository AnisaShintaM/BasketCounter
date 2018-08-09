package com.example.nisa.listview.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nisa.listview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    EditText namaET;
    Button simpanBTN;
    int position;
    FirstFragment.OnSubmitButtonListener listener;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String nama, int position) {
        FirstFragment firstFragment = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putString("nama", nama);
        bundle.putInt("position", position);
        firstFragment.setArguments(bundle);
        return firstFragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        namaET = view.findViewById(R.id.nama_edittext);
        simpanBTN = view.findViewById(R.id.simpan_button);
        namaET.setText(getArguments().getString("nama"));
        position = getArguments().getInt("position");
        simpanBTN.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.simpan_button:
                listener.onSubmitButton(namaET.getText().toString(), position);
                dismiss();
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FirstFragment.OnSubmitButtonListener) {
            listener = (FirstFragment.OnSubmitButtonListener) context;
        } else {
            throw new RuntimeException(context.toString() + " activity harus implement interface OnSubmitButtonListener");
        }
    }

    public interface OnSubmitButtonListener {
        void onSubmitButton(String nama, int position);
    }
}
