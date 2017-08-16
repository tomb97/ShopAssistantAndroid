package com.estimote.indoorapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.estimote.indoorapp.EmpDetails;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by tombarrett on 08/08/2017.
 * Very basic database helper class due to time constraints
 * Methods names shouldn't have to be changed if a more robust implementation is added
 * and therefore little changes outside this class would be needed.
 */

public class DatabaseHelper {
    private SQLiteDatabase db;
    private Context context;

    public DatabaseHelper(Context context){
        this.context=context;
    }

    public void connectToDB(){
        try{
            db = context.openOrCreateDatabase("MyDBIndoor", MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS EmployeeDetails(ID VARCHAR PRIMARY KEY,NAME VARCHAR," +
                    " EMAIL VARCHAR, EMPID VARCHAR, JOB VARCHAR, PHONE VARCHAR);");
        }
        catch (Exception ex){
            Log.d("db", "crash");
        }
    }

    public void disconnectToDB(){
        try{
            db.close();
        }
        catch (Exception ex){
            Log.d("db", "crash");
        }
    }

    public void updateDetails(EmpDetails details){
        try{
            db.execSQL("UPDATE EmployeeDetails SET NAME='"+details.getName()+"',EMAIL='"+details.getEmail()+"',EMPID='"+details.getId()+
                    "',JOB='"+details.getJob()+"',PHONE='"+details.getPhone()+"' WHERE ID='1';");
        }
        catch (Exception ex){
            Log.d("db", "crash");
        }
    }

    public Cursor getDetails(){
        Cursor resultSet = null;
        try{
            resultSet= db.rawQuery("SELECT * FROM EmployeeDetails WHERE ID='1';",null);
        }
        catch (Exception ex){
            Log.d("db", "crash");
        }
        return resultSet;
    }

    public void insertToDB(){
        try{
            db.execSQL("INSERT INTO EmployeeDetails VALUES('1','1',' ',' ','','');");
        }
        catch (Exception ex){
            Log.d("db", "crash");
        }
    }
}
