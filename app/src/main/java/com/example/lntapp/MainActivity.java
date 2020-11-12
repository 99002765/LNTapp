package com.example.lntapp;
import com.example.lntapp.database.FeedReaderContract.FeedEntry;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lntapp.database.DbAccessObj;

public class MainActivity extends AppCompatActivity {
    public static final String MYPREFS = "myprefs";
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String NAMEKEY = "namekey";
    public static final String PWDKEY = "pwdkey";
    EditText nameEditText,pwdEditText;
    DbAccessObj dbAccessObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
        nameEditText= findViewById(R.id.userName);
        pwdEditText= findViewById(R.id.password);
        dbAccessObj= new DbAccessObj(this);
        dbAccessObj.openDb();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
        ListView dbListView = findViewById(R.id.dblistview);
        Uri uriSms = Uri.parse("content://sms/inbox");
        Cursor dataCursor =  getContentResolver().query(uriSms,null,null,null,null);
        //Cursor dataCursor = dbAccessObj.getRows();
        //put the data into adapter
        CursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.row_listview,
                dataCursor,
                new String[]{"body","address"},
                //new String[]{FeedEntry.COLUMN_NAME_TITLE,FeedEntry.COLUMN_NAME_SUBTITLE},
                //"title","subtitle"},
                new int[] {R.id.textviewRow,R.id.textViewsubtitle});
        //set the adapter onto the listview
        dbListView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
        restoreData();
    }

    private void restoreData() {
        //open file
        SharedPreferences preferences= getSharedPreferences(MYPREFS,MODE_PRIVATE);
        //read from the file
        String name = preferences.getString(NAMEKEY,"");
        String pwd = preferences.getString(PWDKEY,"");
        //set data in UI
        nameEditText.setText(name);
        pwdEditText.setText(pwd);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
        saveData();
    }

    private void saveData() {
        //Get data from UI
        String name = nameEditText.getText().toString();
        String pwd = pwdEditText.getText().toString();
        //Create file named myprefs
        SharedPreferences preferences= getSharedPreferences(MYPREFS,MODE_PRIVATE);
        //open file
        SharedPreferences.Editor editor= preferences.edit();
        //write to the file
        editor.putString(NAMEKEY,name);
        editor.putString(PWDKEY,pwd);
        //save file
        editor.apply();
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
    public void handleDb(View view) {
        switch (view.getId()){
            case R.id.buttonput:
                String title= nameEditText.getText().toString();
                String subtitle= pwdEditText.getText().toString();
                dbAccessObj.createRow(title,subtitle);
                break;
            case R.id.buttonget:
                String data = dbAccessObj.readRow();
                TextView dbTextView= findViewById(R.id.textViewdb);
                dbTextView.setText(data);
                break;
        }
    }
//    private void getCredentials() {
//        dbAccessObj.query(nameEditText.getText().toString());
//    }
    private void getCredentials() {
        String pwd = dbAccessObj.query(nameEditText.getText().toString());
        pwdEditText.setText(pwd);
    }
    public void cancelClick(View view) {
        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
        TextView welcomeTextView;
        welcomeTextView=findViewById(R.id.textViewWelcome);
        welcomeTextView.setText("Welcome to L&T");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:1234567890"));
        startActivity(intent);
    }
    public void loginClick(View view) {
//        EditText userName,pwd;
//        userName=findViewById(R.id.userName);
//        pwd=findViewById(R.id.password);
//        String uname=userName.getText().toString();
//        String pass=pwd.getText().toString();
//        if(uname.equals("Sandeep") && pass.equals("123456")){
//            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
//            Intent hIntent= new Intent(MainActivity.this, HomeActivity.class);
//            hIntent.putExtra("userName",uname);
//            startActivity(hIntent);
//        }
//        else{
//            Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
//        }
//        TextView welcomeTextView;
//        welcomeTextView=findViewById(R.id.textViewWelcome);
//        welcomeTextView.setText("Username: "+uname+" Password: "+pass);
        getCredentials();
    }
}