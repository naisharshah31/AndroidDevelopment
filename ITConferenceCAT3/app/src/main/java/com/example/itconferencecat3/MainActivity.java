package com.example.itconferencecat3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private HillTop fragmentHillTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentHillTop = new HillTop();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment1, fragmentHillTop)
                .commit();

    }
}