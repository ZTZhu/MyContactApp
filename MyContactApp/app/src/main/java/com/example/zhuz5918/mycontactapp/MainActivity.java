package com.example.zhuz5918.mycontactapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName;
    EditText editAge;
    EditText editAddress;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        editName = (EditText) findViewById(R.id.editText_name);
        editAge = (EditText) findViewById(R.id.editText_age);
        editAddress = (EditText) findViewById(R.id.editText_address);
    }

    public void addData(View v){
        boolean isInserted = myDb.insertData(editName.getText().toString(), editAge.getText().toString(), editAddress.getText().toString());

        if(isInserted){
            Log.d("MyContact", "Data insertion successful");
            //Create toast message to user indicating data inserted correctly
            Toast.makeText(v.getContext(), "Success", Toast.LENGTH_LONG).show();
        }
        else{
            Log.d("MyContact", "Data insertion NOT successful");
            //Create toast message to user indicating data inserted correctly
            Toast.makeText(v.getContext(), "No success", Toast.LENGTH_LONG).show();
        }
    }
    
    public void viewData(View v){
        Cursor res = myDb.getAllData();
        if(res.getCount() == 0){
            showMessage("Error", "No data found in database");
            Log.d("MyContact", "Error");
            return;
        }
    }
    StringBuffer buffer = new StringBuffer();
    //setup loop with moveToNext method
    //append each COL to buffer
    //use getString method

    //showMessage("Data", Buffer.toString());

    private void showMessage(String title, String message) {
    }







    /***
     *
     * 
     *
     *
    public void addData(View v){
     boolean isInserted = myDb.insertData(editName.getText().toString());
     if(isInserted){
     Log.d("MyContact", "Name data insertion successful");
     //Create toast message to user indicating data inserted correctly
     }
     else{
     Log.d("MyContact", "Name data insertion NOT successful");
     //Create toast message to user indicating data inserted correctly
     }
     }
    public void addAge(View v){
        boolean isInserted = myDb.insertData(editAge.getText().toString());
        if(isInserted){
            Log.d("MyContact", "Age data insertion successful");
            //Create toast message to user indicating data inserted correctly
        }
        else{
            Log.d("MyContact", "Age data insertion NOT successful");
            //Create toast message to user indicating data inserted correctly
        }
    }

    public void addAddress(View v){
        boolean isInserted = myDb.insertData(editAddress.getText().toString());
        if(isInserted){
            Log.d("MyContact", "Address data insertion successful");
            //Create toast message to user indicating data inserted correctly
        }
        else{
            Log.d("MyContact", "Address data insertion NOT successful");
            //Create toast message to user indicating data inserted correctly
        }
    }
    ***/

}
