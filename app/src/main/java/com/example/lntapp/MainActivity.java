package com.example.lntapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    public void cancelClick(View view) {
        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
        TextView welcomeTextView;
        welcomeTextView=findViewById(R.id.textViewWelcome);
        welcomeTextView.setText("Welcome to L&T");
    }
    public void loginClick(View view) {
        EditText userName,pwd;
        userName=findViewById(R.id.userName);
        pwd=findViewById(R.id.password);
        String uname=userName.getText().toString();
        String pass=pwd.getText().toString();
        if(uname.equals("Sandeep") && pass.equals("123456")){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent hIntent= new Intent(MainActivity.this, HomeActivity.class);
            hIntent.putExtra("userName",uname);
            startActivity(hIntent);
        }
        else{
            Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
        }
        TextView welcomeTextView;
        welcomeTextView=findViewById(R.id.textViewWelcome);
        welcomeTextView.setText("Username: "+uname+" Password: "+pass);
    }
}