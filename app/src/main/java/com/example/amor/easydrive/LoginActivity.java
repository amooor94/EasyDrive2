package com.example.amor.easydrive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;


public class LoginActivity extends Activity {




    protected EditText mUsernname;
    protected EditText mPassword;
    protected Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        // Enable Local Datastore.
        setContentView(R.layout.activity_login);


        //initialize
        mUsernname = (EditText)findViewById(R.id.usernameLoginText);
        mPassword = (EditText)findViewById(R.id.passwordLoginText);
        mLoginBtn = (Button)findViewById(R.id.LoginBtn);


        //Listen to when Login button is clicked
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the user inputs and convert to string
                final String username = mUsernname.getText().toString().trim();
                String password = mPassword.getText().toString().trim();


                //Login the user using parse
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {



                        if(e == null){

                            if (username.equals("manager")) {
                                Toast.makeText(LoginActivity.this, "Logged in as Manager!", Toast.LENGTH_LONG).show();
                                Intent takeUserHome = new Intent(LoginActivity.this, ManagerActivityPage.class);
                                startActivity(takeUserHome);

                            } else {
                                Toast.makeText(LoginActivity.this, "Logged in as Driver!", Toast.LENGTH_LONG).show();
                                Intent takeUserHome = new Intent(LoginActivity.this, UserActivityPage.class);
                                startActivity(takeUserHome);

                            }



                        }else{

                        }




                    }
                });



            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
