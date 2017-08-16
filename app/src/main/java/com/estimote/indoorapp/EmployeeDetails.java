package com.estimote.indoorapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.estimote.indoorapp.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetails extends AppCompatActivity {

    private DatabaseHelper dbhelper;
    private EmpDetails details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        dbhelper= new DatabaseHelper(this);
        dbhelper.connectToDB();
        Cursor resultSet=dbhelper.getDetails();

        if(resultSet!=null && resultSet.moveToFirst()){
            ((EditText) findViewById(R.id.editText)).setText((resultSet.getString(1)), TextView.BufferType.EDITABLE);
            ((EditText) findViewById(R.id.editText2)).setText(resultSet.getString(2), TextView.BufferType.EDITABLE);
            ((EditText) findViewById(R.id.editText3)).setText(resultSet.getString(3), TextView.BufferType.EDITABLE);
            ((EditText) findViewById(R.id.editText4)).setText(resultSet.getString(4), TextView.BufferType.EDITABLE);
            ((EditText) findViewById(R.id.editText5)).setText(resultSet.getString(5), TextView.BufferType.EDITABLE);

            dbhelper.disconnectToDB();
            details=new EmpDetails();
            details.setName(((EditText) findViewById(R.id.editText)).getText().toString());
            details.setEmail(((EditText) findViewById(R.id.editText2)).getText().toString());
            details.setJob(((EditText) findViewById(R.id.editText4)).getText().toString());
            details.setPhone(((EditText) findViewById(R.id.editText5)).getText().toString());
            details.setId(((EditText) findViewById(R.id.editText3)).getText().toString());
        }
        else{
            Log.d("DB","Empty");
            dbhelper.insertToDB();
            dbhelper.disconnectToDB();
        }
        Button buttonSave= (Button) findViewById(R.id.button3);
        buttonSave.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                updateDetails();
            }
        });
    }

    public void updateDetails(){
        details=new EmpDetails();
        details.setName(((EditText) findViewById(R.id.editText)).getText().toString());
        details.setEmail(((EditText) findViewById(R.id.editText2)).getText().toString());
        details.setJob(((EditText) findViewById(R.id.editText4)).getText().toString());
        details.setPhone(((EditText) findViewById(R.id.editText5)).getText().toString());
        details.setId(((EditText) findViewById(R.id.editText3)).getText().toString());
        dbhelper.connectToDB();
        dbhelper.updateDetails(details);
        dbhelper.disconnectToDB();

    }
}
