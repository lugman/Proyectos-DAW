/*
 * Created by Lugman Sami 2/06/17 18:522/06/17 18:52
 * Copyright (c) 2017.
 * you the  lugman	don't have right to modifify or alter this app.
 */

package es.com.lugman.www.diarytask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lugman on 28/05/17.
 */


public class DataBaseSQLite extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "TareaB";

    // Contacts table name
    private static final String TABLE_TASK = "Taskt";
    private static final String TABLE_TASK2 = "Note";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMPORTANCE = "importance";
    private static final String KEY_DATE_YEAR = "year";
    private static final String KEY_DATE_MONTH = "month";
    private static final String KEY_DATE_DAY = "day";
    private static final String KEY_HOUR = "hour";
    private static final String KEY_MINUTE = "minute";
    private static final String KEY_CHECK = "clicked";

    public DataBaseSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_TASK + "( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " TEXT, "+ KEY_IMPORTANCE + " TEXT, "
                + KEY_DATE_YEAR + " TEXT, " + KEY_DATE_MONTH + " TEXT, " + KEY_DATE_DAY + " TEXT, " + KEY_HOUR + " TEXT, " + KEY_MINUTE + " TEXT, " + KEY_CHECK + " TEXT " + ")";

        db.execSQL(CREATE_TABLE);
        String CREATE_TABLE2 = "CREATE TABLE " + TABLE_TASK2 + "( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " TEXT, "
                + KEY_DATE_YEAR + " TEXT, " + KEY_DATE_MONTH + " TEXT, " + KEY_DATE_DAY + " TEXT )";
        db.execSQL(CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
    public void addtask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, task.getTask());
        values.put(KEY_IMPORTANCE, task.getImportance());
        values.put(KEY_DATE_YEAR,task.getYear());
        values.put(KEY_DATE_MONTH,task.getMonth());
        values.put(KEY_DATE_DAY,task.getDay());
        values.put(KEY_HOUR,task.getHour());
        values.put(KEY_MINUTE,task.getMinute());
        values.put(KEY_CHECK,task.getCheck());

        db.insert(TABLE_TASK, null, values);
        db.close(); // Closing database connection
    }
    public Task gettask(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_TASK, new String[] { KEY_ID, KEY_NAME, KEY_IMPORTANCE,KEY_DATE_YEAR,KEY_DATE_MONTH,KEY_DATE_DAY,KEY_HOUR,KEY_MINUTE,KEY_CHECK }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        int a= Integer.parseInt(cursor.getString(0));
        String b= String.valueOf(a);
        Task tar = new Task(cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
        tar.setId(b);
        tar.setCheck(cursor.getString(6));

// return shop
        return tar;
    }
    public List<Task> getTasks() {
        List<Task> taskList = new ArrayList<Task>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_TASK;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Task shop = new Task();
                shop.setId(String.valueOf(Integer.parseInt(cursor.getString(0))));
                shop.setTask(String.valueOf(cursor.getString(1)));
                shop.setImportance(cursor.getString(2));
                shop.setYear(cursor.getString(3));
                shop.setMonth(cursor.getString(4));
                shop.setDay(cursor.getString(5));
                shop.setHour(cursor.getString(6));
                shop.setMinute(cursor.getString(7));
                shop.setCheck(cursor.getString(8));
// Adding contact to list
                taskList.add(shop);
            } while (cursor.moveToNext());
        }
// return contact list
        return taskList;
    }
    public void deleteTasks(Task shop) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASK, KEY_ID + " = ?",
                new String[] { shop.getId() });
        db.close();
    }
    public int updateTask( Task task )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, task.getTask());
        values.put(KEY_IMPORTANCE, task.getImportance());
        values.put(KEY_DATE_YEAR,task.getYear());
        values.put(KEY_DATE_MONTH,task.getMonth());
        values.put(KEY_DATE_DAY,task.getDay());
        values.put(KEY_HOUR,task.getHour());
        values.put(KEY_MINUTE,task.getMinute());
        values.put(KEY_CHECK,task.getCheck());
        return db.update(TABLE_TASK, values, KEY_ID + " = " + task.getId() , null);
    }
    public void addtask2(Task task) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, task.getTask());
        values.put(KEY_DATE_YEAR,task.getYear());
        values.put(KEY_DATE_MONTH,task.getMonth());
        values.put(KEY_DATE_DAY,task.getDay());

        db.insert(TABLE_TASK2, null, values);

        db.close(); // Closing database connection
    }
    public void deleteTasks2(Task shop) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASK2, KEY_ID + " = ?",
                new String[] { shop.getId() });
        db.close();
    }

    public List<Task> getTasks2() {
        List<Task> taskList = new ArrayList<Task>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_TASK2;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Task shop = new Task();
                shop.setId(String.valueOf(Integer.parseInt(cursor.getString(0))));
                shop.setTask(String.valueOf(cursor.getString(1)));
                shop.setYear(cursor.getString(2));
                shop.setMonth(cursor.getString(3));
                shop.setDay(cursor.getString(4));
                Log.d("VA",String.valueOf(cursor.getCount()));

// Adding contact to list
                taskList.add(shop);
            } while (cursor.moveToNext());
        }
// return contact list
        return taskList;
    }
}
