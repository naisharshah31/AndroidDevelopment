package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    String toast_message;
    Button toastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = (TextView) findViewById(R.id.show_count);
        toast_message =  getResources().getString(R.string.toast_message);
        toastButton  = (Button) findViewById(R.id.button_toast);



    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this,  sendToast() ,
                Toast.LENGTH_LONG);

        toast.show();

    }

    public String sendToast() {
        return  toast_message + " : " + (Integer.toString(mCount));
    }

    public void countUp(View view) {
        mCount+=1;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }



}