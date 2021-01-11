package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    EditText number1_input;
    EditText number2_input;
    TextView answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.option_spinner);
        spinner.setOnItemSelectedListener(this);

        number1_input   = (EditText)findViewById(R.id.number1);
        number2_input   = (EditText)findViewById(R.id.number2);
        answer = (TextView) findViewById(R.id.answer);



        List<String> options = new ArrayList<String>();
        options.add("+");
        options.add("-");
        options.add("*");
        options.add("/");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String item = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        // TODO Auto-generated method stub

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    public void calculate(View view) {

        String option = spinner.getSelectedItem().toString();
        String number1 = number1_input.getText().toString();
        String number2 = number2_input.getText().toString();

        /*Toast toast = Toast.makeText(this, (number1 + number2),
                Toast.LENGTH_LONG);

        toast.show();*/

        //VALIDATION
        if ( number1.matches("") || number2.matches("") ) {
            Toast toast = Toast.makeText(this, "Please enter both values",
                    Toast.LENGTH_LONG);
            toast.show();
        } else {

            float ans = 0;


            if (option == "+") {
                ans = Float.parseFloat(number1) + Float.parseFloat(number2);
                answer.setText( Float.toString(ans) );
            } else if ( option == "-" ) {
                ans = Float.parseFloat(number1) - Float.parseFloat(number2);
                answer.setText( Float.toString(ans) );
            } else if ( option == "*" ) {
                ans = Float.parseFloat(number1) * Float.parseFloat(number2);
                answer.setText( Float.toString(ans) );
            } else if ( option == "/" ) {
                ans = Float.parseFloat(number1) / Float.parseFloat(number2);
                answer.setText( Float.toString(ans) );
            }

        }


    }
}