package com.example.nisa.convertersuhuanisa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText inputET;
    Spinner fromSpinner, toSpinner;
    TextView hasilTV;
    //Button submitBTN;
    String selectedFrom;
    String selectedTo;
    String inputString;

    Double awal, celcius, reamur, fahrenheit, kelvin;
    private final TextWatcher inputWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //textView.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {
            methodHitung();
        }
    };
    ArrayList<String> listFrom = new ArrayList<>();
    ArrayList<String> listTo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputET = findViewById(R.id.suhu_edittext);
        hasilTV = findViewById(R.id.hasil_textview);

        fromSpinner = findViewById(R.id.from_spinner);
        toSpinner = findViewById(R.id.to_spinner);
        fromSpinner.setOnItemSelectedListener(this);
        toSpinner.setOnItemSelectedListener(this);

        //submitBTN = findViewById(R.id.submit_button);
        inputET.addTextChangedListener(inputWatcher);
        //submitBTN.setOnClickListener(this);


        //listfrom
        listFrom.add("CELCIUS");
        listFrom.add("REAMUR");
        listFrom.add("KELVIN");
        listFrom.add("FAHRENHEIT");

        //listTo
        listTo.add("CELCIUS");
        listTo.add("REAMUR");
        listTo.add("KELVIN");
        listTo.add("FAHRENHEIT");

        ArrayAdapter<String> fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listFrom);
        fromSpinner.setAdapter(fromAdapter);

        ArrayAdapter<String> toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listFrom);
        toSpinner.setAdapter(toAdapter);
        //end

    }

    //    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id) {
//            case R.id.submit_button:
//                inputString = inputET.getText().toString();
//                String satuan = String.valueOf(fromSpinner.getSelectedItemPosition());
//                String tujuan = String.valueOf(toSpinner.getSelectedItemPosition());
//
//                if (TextUtils.isEmpty(inputString)) {
//                    Toast.makeText(getApplicationContext(), "Mohon Isikan Suhu", Toast.LENGTH_SHORT).show();
//                } else {
//                    awal = Double.parseDouble(inputET.getText().toString());
//                    if (satuan.equals("0") && tujuan.equals("0")) {
//                        celcius = awal;
////                        reamur = 0.8 * awal;
////                        fahrenheit = (1.8 * awal) + 32;
////                        kelvin = awal + 273;
//                        hasilTV.setText(String.valueOf(celcius));
//                    }
//                    else if(satuan.equals("0") && tujuan.equals("1"))
//                    {
//                        celcius = awal;
//                        reamur = 0.8 * awal;
//                        hasilTV.setText(String.valueOf(reamur));
//                    }
//                    else if(satuan.equals("0") && tujuan.equals("2")) //c-k
//                    {
//                        celcius = awal;
//                        kelvin = awal + 273;
//                        hasilTV.setText(String.valueOf(kelvin));
//                    }
//
//                    else if(satuan.equals("0") && tujuan.equals("3"))
//                    {
//                        celcius = awal;
//                        fahrenheit = (1.8 * awal) + 32;
//                        hasilTV.setText(String.valueOf(fahrenheit));
//                    }
//                    else if(satuan.equals("0") && tujuan.equals("0")){
//                        celcius = awal;
//                        hasilTV.setText(String.valueOf(celcius));
//                    }
//
//                    //reamur to c
//                    else if(satuan.equals("1") && tujuan.equals("0"))
//                    {
//                        celcius = 1.25 * awal;
//                        reamur = awal;
//                        hasilTV.setText(String.valueOf(celcius));
//                    }
//
//                    //reamur remaur
//                    else if(satuan.equals("1") && tujuan.equals("1"))
//                    {
//                        celcius = 1.25 * awal;
//                        reamur = awal;
//                        hasilTV.setText(String.valueOf(reamur));
//                    }
//
//                    //r - k
//                    else if(satuan.equals("1") && tujuan.equals("2"))
//                    {
//                        celcius = 1.25 * awal;
//                        reamur = awal;
//                        kelvin = awal + 273;
//                        hasilTV.setText(String.valueOf(kelvin));
//
//                    }
//
//                    //r - f
//                    else if(satuan.equals("1") && tujuan.equals("3"))
//                    {
//                        celcius = 1.25 * awal;
//                        reamur = awal;
//                        fahrenheit = (2.25 * awal) + 32;
//                        kelvin = celcius + 273;
//                        hasilTV.setText(String.valueOf(fahrenheit));
//                    }
//
//                    //kelvin - celcius
//                    else if(satuan.equals("2") && tujuan.equals("0"))
//                    {
//                        celcius = awal-273;
//                        reamur = 0.8 * (awal-273);
//                        fahrenheit = (1.8 * (awal-273)) + 32;
//                        kelvin = awal;
//                        hasilTV.setText(String.valueOf(celcius));
//                    }
//                    else if(satuan.equals("2") && tujuan.equals("1"))
//                    {
//                        celcius = awal-273;
//                        reamur = 0.8 * (awal-273);
//                        fahrenheit = (1.8 * (awal-273)) + 32;
//                        kelvin = awal;
//                        hasilTV.setText(String.valueOf(reamur));
//                    }
//                    else if(satuan.equals("2") && tujuan.equals("2"))
//                    {
//                        celcius = awal-273;
//                        reamur = 0.8 * (awal-273);
//                        fahrenheit = (1.8 * (awal-273)) + 32;
//                        kelvin = awal;
//                        hasilTV.setText(String.valueOf(kelvin));
//                    }
//                    else if(satuan.equals("2") && tujuan.equals("3"))
//                    {
//                        celcius = awal-273;
//                        reamur = 0.8 * (awal-273);
//                        fahrenheit = (1.8 * (awal-273)) + 32;
//                        kelvin = awal;
//                        hasilTV.setText(String.valueOf(fahrenheit));
//                    }
//
//                    else if(satuan.equals("3") && tujuan.equals("0"))
//                    {
//                        celcius = 0.55555 *(awal - 32);
//                        reamur = 0.44444 * (awal-32);
//                        fahrenheit = awal;
//                        kelvin = celcius + 273;
//                        hasilTV.setText(String.valueOf(celcius));
//
//                    }
//                    else if(satuan.equals("3") && tujuan.equals("1"))
//                    {
//                        celcius = 0.55555 *(awal - 32);
//                        reamur = 0.44444 * (awal-32);
//                        fahrenheit = awal;
//                        kelvin = celcius + 273;
//                        hasilTV.setText(String.valueOf(reamur));
//
//                    }
//                    else if(satuan.equals("3") && tujuan.equals("2"))
//                    {
//                        celcius = 0.55555 *(awal - 32);
//                        reamur = 0.44444 * (awal-32);
//                        fahrenheit = awal;
//                        kelvin = celcius + 273;
//                        hasilTV.setText(String.valueOf(kelvin));
//
//                    }
//                    else if(satuan.equals("3") && tujuan.equals("3"))
//                    {
//                        celcius = 0.55555 *(awal - 32);
//                        reamur = 0.44444 * (awal-32);
//                        fahrenheit = awal;
//                        kelvin = celcius + 273;
//                        hasilTV.setText(String.valueOf(fahrenheit));
//                    }
//
//hytj
//                }
//
//
//        }
//    }hjhj
    public void methodHitung() {
        inputString = inputET.getText().toString();
        String satuan = String.valueOf(fromSpinner.getSelectedItemPosition());
        String tujuan = String.valueOf(toSpinner.getSelectedItemPosition());

        if (TextUtils.isEmpty(inputString)) {
            //Toast.makeText(getApplicationContext(), "Mohon Isikan Suhu", Toast.LENGTH_SHORT).show();
        } else {
            awal = Double.parseDouble(inputET.getText().toString());
            if (satuan.equals("0") && tujuan.equals("0")) {
                celcius = awal;
//                        reamur = 0.8 * awal;
//                        fahrenheit = (1.8 * awal) + 32;
//                        kelvin = awal + 273;
                hasilTV.setText(String.valueOf(celcius));
            } else if (satuan.equals("0") && tujuan.equals("1")) {
                celcius = awal;
                reamur = 0.8 * awal;
                hasilTV.setText(String.valueOf(reamur));
            } else if (satuan.equals("0") && tujuan.equals("2")) //c-k
            {
                celcius = awal;
                kelvin = awal + 273;
                hasilTV.setText(String.valueOf(kelvin));
            } else if (satuan.equals("0") && tujuan.equals("3")) {
                celcius = awal;
                fahrenheit = (1.8 * awal) + 32;
                hasilTV.setText(String.valueOf(fahrenheit));
            } else if (satuan.equals("0") && tujuan.equals("0")) {
                celcius = awal;
                hasilTV.setText(String.valueOf(celcius));
            }

            //reamur to c
            else if (satuan.equals("1") && tujuan.equals("0")) {
                celcius = 1.25 * awal;
                reamur = awal;
                hasilTV.setText(String.valueOf(celcius));
            }

            //reamur remaur
            else if (satuan.equals("1") && tujuan.equals("1")) {
                celcius = 1.25 * awal;
                reamur = awal;
                hasilTV.setText(String.valueOf(reamur));
            }

            //r - k
            else if (satuan.equals("1") && tujuan.equals("2")) {
                celcius = 1.25 * awal;
                reamur = awal;
                kelvin = awal + 273;
                hasilTV.setText(String.valueOf(kelvin));

            }

            //r - f
            else if (satuan.equals("1") && tujuan.equals("3")) {
                celcius = 1.25 * awal;
                reamur = awal;
                fahrenheit = (2.25 * awal) + 32;
                kelvin = celcius + 273;
                hasilTV.setText(String.valueOf(fahrenheit));
            }

            //kelvin - celcius
            else if (satuan.equals("2") && tujuan.equals("0")) {
                celcius = awal - 273;
                reamur = 0.8 * (awal - 273);
                fahrenheit = (1.8 * (awal - 273)) + 32;
                kelvin = awal;
                hasilTV.setText(String.valueOf(celcius));
            } else if (satuan.equals("2") && tujuan.equals("1")) {
                celcius = awal - 273;
                reamur = 0.8 * (awal - 273);
                fahrenheit = (1.8 * (awal - 273)) + 32;
                kelvin = awal;
                hasilTV.setText(String.valueOf(reamur));
            } else if (satuan.equals("2") && tujuan.equals("2")) {
                celcius = awal - 273;
                reamur = 0.8 * (awal - 273);
                fahrenheit = (1.8 * (awal - 273)) + 32;
                kelvin = awal;
                hasilTV.setText(String.valueOf(kelvin));
            } else if (satuan.equals("2") && tujuan.equals("3")) {
                celcius = awal - 273;
                reamur = 0.8 * (awal - 273);
                fahrenheit = (1.8 * (awal - 273)) + 32;
                kelvin = awal;
                hasilTV.setText(String.valueOf(fahrenheit));
            } else if (satuan.equals("3") && tujuan.equals("0")) {
                celcius = 0.55555 * (awal - 32);
                reamur = 0.44444 * (awal - 32);
                fahrenheit = awal;
                kelvin = celcius + 273;
                hasilTV.setText(String.valueOf(celcius));

            } else if (satuan.equals("3") && tujuan.equals("1")) {
                celcius = 0.55555 * (awal - 32);
                reamur = 0.44444 * (awal - 32);
                fahrenheit = awal;
                kelvin = celcius + 273;
                hasilTV.setText(String.valueOf(reamur));

            } else if (satuan.equals("3") && tujuan.equals("2")) {
                celcius = 0.55555 * (awal - 32);
                reamur = 0.44444 * (awal - 32);
                fahrenheit = awal;
                kelvin = celcius + 273;
                hasilTV.setText(String.valueOf(kelvin));

            } else if (satuan.equals("3") && tujuan.equals("3")) {
                celcius = 0.55555 * (awal - 32);
                reamur = 0.44444 * (awal - 32);
                fahrenheit = awal;
                kelvin = celcius + 273;
                hasilTV.setText(String.valueOf(fahrenheit));
            }


        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedFrom = fromSpinner.getSelectedItem().toString();
        selectedTo = toSpinner.getSelectedItem().toString();
        methodHitung();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

