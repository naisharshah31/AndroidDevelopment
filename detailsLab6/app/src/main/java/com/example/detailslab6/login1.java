package com.example.detailslab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login1 extends AppCompatActivity {
    private Button mLogin;
    private TextInputEditText mUsername , mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);

        mLogin = findViewById(R.id.login_button);


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("users");

                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();

                reference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            //IF username exists then break control
                            reference.orderByChild("password").equalTo(password).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if (snapshot.exists()) {
                                        Intent myIntent = new Intent(login1.this,  mcq.class);
                                        login1.this.startActivity(myIntent);
                                    } else {
                                        Toast.makeText(login1.this, "Sorry wrong password!" ,Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        } else {
                            Toast.makeText(login1.this, "Sorry no such Username exists!" ,Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }


                });



            }
        });


    }
}