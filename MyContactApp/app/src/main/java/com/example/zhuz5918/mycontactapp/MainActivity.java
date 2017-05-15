package com.example.zhuz5918.mycontactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);
    }

    public void addData(View v){
        boolean isInserted = myDb.insertData(editName.getText().toString());

        if(isInserted){
            Log.d("MyContact", "Data insertion successful");
            //Create toast message to user indicating data inserted correctly
        }
        else{
            Log.d("MyContact", "Data insertion NOT successful");
            //Create toast message to user indicating data inserted correctly
        }
    }

}
