package com.example.zhuz5918.mycontactapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Note to self: Phone #9 is the one that magically makes stuff work
 */
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

    public void addData(View v) {
        boolean isInserted = myDb.insertData(editName.getText().toString(), editAge.getText().toString(), editAddress.getText().toString());

        if (isInserted) {
            Log.d("MyContact", "Data insertion successful");
            //Create toast message to user indicating data inserted correctly
            Toast.makeText(v.getContext(), "Success", Toast.LENGTH_LONG).show();
        } else {
            Log.d("MyContact", "Data insertion NOT successful");
            //Create toast message to user indicating data inserted correctly
            Toast.makeText(v.getContext(), "No success", Toast.LENGTH_LONG).show();
        }
    }

    public void viewData(View v) {
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            showMessage("Error", "No data found in database");
            Log.d("MyContact", "Error");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
        buffer.append("Name: " + res.getString(1));
        buffer.append(" /// Address: " + res.getString(2));
        buffer.append(" /// Age: " + res.getString(3));
        buffer.append("\n\n");
        }
        showMessage("Data", buffer.toString());
        Log.d("MyContact", buffer.toString());
    }

    public void searchName(View v, String name){
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            showMessage("Error", "No data found in database");
            Log.d("MyContact", "Error");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            if(res.getString(1).equals(name)){
                buffer.append("Name: " + res.getString(1));
                buffer.append("Address: " + res.getString(2));
                buffer.append("Age: " + res.getString(3));
            }
            showMessage("Data", buffer.toString());
            Log.d("MyContact", buffer.toString());
        }
    }

    //setup loop with moveToNext method
    //append each COL to buffer
    //use getString method

    //showMessage("Data", Buffer.toString());

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }



}
