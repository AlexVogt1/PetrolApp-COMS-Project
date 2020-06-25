package com.example.petrolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void gotoLoginPage(View v){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

    public void gotosignupPage(View V){
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }

    public void gotoforgotpassword(View V){
        Intent intent = new Intent(this,Forgot_password.class);
        startActivity(intent);
    }

    public void openForgotPassword(){
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
}
