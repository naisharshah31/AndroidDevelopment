package com.example.detailslab6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Boolean.*;


public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private RadioGroup ageGroup;
    private RadioButton ageOption;
    private CheckBox optionSurat, optionBangalore, optionMysore, optionDelhi;
    private Button submit;
    private int flag;
    private String dbAge, dbCities;
    private TextView mAlreadyAccount;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALIZATION
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        ageGroup = findViewById(R.id.ageGroup);
        optionSurat = findViewById(R.id.optionCitySurat);
        optionBangalore = findViewById(R.id.optionCityBangalore);
        optionMysore = findViewById(R.id.optionCityMysore);
        optionDelhi = findViewById(R.id.optionCityDelhi);
        mAlreadyAccount = findViewById(R.id.alreadyAccount);
        submit = findViewById(R.id.submitButton);

        mAlreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,  login1.class);
                MainActivity.this.startActivity(myIntent);
            }
        });



        //SUBMIT BUTTON EVENT CONTROLLER
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("users");


                StringBuffer displayMsg = new StringBuffer();
                displayMsg.append("Username: ");
                flag = 0;
                dbAge = "";
                dbCities = "";

                String user = username.getText().toString();
                String pass = password.getText().toString();

                //VALIDATION
                if (user.matches("") ) {
                    flag = -1;

                    Toast toast = Toast.makeText(MainActivity.this, "Please enter username",
                            Toast.LENGTH_LONG);
                    toast.show();
                    return;
                } else {
                    displayMsg.append(user).append("\n");
                }

                if (pass.matches("") ) {
                    flag = -1;

                    Toast toast = Toast.makeText(MainActivity.this, "Please enter password",
                            Toast.LENGTH_LONG);
                    toast.show();
                    return;
                } else {
                    displayMsg.append(user).append("\n");
                }


                //This function return -1 if no radio button is selected in that group
                int radioID = ageGroup.getCheckedRadioButtonId();
                ageOption = findViewById(radioID);

                //VALIDATION
                if (radioID == -1) {
                    flag = -1;
                    Toast toast = Toast.makeText(MainActivity.this, "Please enter age",
                            Toast.LENGTH_LONG);
                    toast.show();
                    return;
                } else {
                    displayMsg.append("Age Group: ");
                    displayMsg.append(ageOption.getText()).append("\n");
                    dbAge =  ageOption.getText().toString();
                }


                //VALIDATION
                if (optionSurat.isChecked() == FALSE && optionBangalore.isChecked() == FALSE && optionMysore.isChecked() == FALSE && optionDelhi.isChecked() == FALSE) {
                    flag = -1;
                    Toast toast = Toast.makeText(MainActivity.this, "Please select at least one city",
                            Toast.LENGTH_LONG);
                    toast.show();
                    return;
                } else {
                    displayMsg.append("Preferred City: ");
                    if(optionSurat.isChecked()){
                        displayMsg.append(optionSurat.getText());
                        dbCities += optionSurat.getText();
                    }
                    if(optionBangalore.isChecked()){
                        displayMsg.append(", ").append(optionBangalore.getText());
                        dbCities += ", " + optionBangalore.getText();
                    }
                    if(optionMysore.isChecked()){
                        displayMsg.append(", ").append(optionMysore.getText());
                        dbCities += ", " + optionMysore.getText();
                    }
                    if(optionDelhi.isChecked()){
                        displayMsg.append(", ").append(optionDelhi.getText());
                        dbCities += ", " + optionDelhi.getText();
                    }
                }

                //FINAL DISPLAY MESSAGE if there is no error and if every criteria is satisfied flag value is 0.
                if (flag == 0) {
                    UserHelperClass helperClass = new UserHelperClass(user, dbAge, dbCities, pass);

                    //Checking whether username exists in database or not.
                    reference.orderByChild("username").equalTo(user).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                //IF username exists then break control
                                Toast.makeText(MainActivity.this, "Sorry! Username already exists!" ,Toast.LENGTH_SHORT).show();
                                return;
                            } else {
                                //Else INSERT IN FIREBASE..
                                reference.child(user).setValue(helperClass, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                        Toast.makeText(MainActivity.this, "Welcome! " + user,Toast.LENGTH_SHORT).show();
                                        Intent myIntent = new Intent(MainActivity.this,  login1.class);
                                        MainActivity.this.startActivity(myIntent);
                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }


                    });
                }
            }
        });
    }
}