package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //initializations
    private EditText userId;
    private EditText password;
    private Button login;
    private String successfulLogin = "Login Successful";
    private String failLogin = "Invalid credentials";
    private String longPressMessage = "Successful login will navigate you to a wonderful world of learning";
    private String emptyMessage = "Please enter all details ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // handle all the drawing related activity which are done in parent class
        setContentView(R.layout.activity_main); //set the content view of the argument i.e. xml layout present in res

        //Mapping the UI elements with variables using their Id
        userId = findViewById(R.id.etUserId);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.btnLogin);


        ////This will execute when Login button is clicked which consequently call validateCredentials function.
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateCredentials(userId.getText().toString(), password.getText().toString());
            }
        });

        //This will execute when Login button is long pressed for couple of seconds, then it display a toast
        login.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(),longPressMessage,Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    //This function is for validating the credentials and depending of userInput create respective toast
    private  void validateCredentials(String userId, String password)
    {
        //This will execute when valid credentials are entered
        if(userId.equals("Test")&& password.equals("Test"))
        {
            //This will create Toast with successful message
            Toast.makeText(getApplicationContext(),successfulLogin,Toast.LENGTH_LONG).show();
            //This creates the second activity using intent and will direct to send page after successful Login
            Intent secondPage = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(secondPage);
        }


        //This will execute when  credentials are empty
        else if(userId.equals("")|| password.equals(""))
        {
            Toast.makeText(getApplicationContext(),emptyMessage,Toast.LENGTH_LONG).show();
        }
        //This will execute when invalid credentials are entered
        else
        {
            Toast.makeText(getApplicationContext(),failLogin,Toast.LENGTH_LONG).show();
        }

    }

}
