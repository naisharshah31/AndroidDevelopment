package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner operationSpinner = findViewById(R.id.operation);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operationSpinner.setAdapter(adapter);
        operationSpinner.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String optionOperation = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, optionOperation, Toast.LENGTH_LONG).show();
    }
}