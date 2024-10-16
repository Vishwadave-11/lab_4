package com.example.todoapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class ToDoDAO {
    private SQLiteDatabase db;
    private ToDoDatabaseHelper dbHelper;

    public ToDoDAO(Context context) {
        dbHelper = new ToDoDatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // Method to add a new task
    public long addTask(String task) {
        ContentValues values = new ContentValues();
        values.put(ToDoDatabaseHelper.COLUMN_TASK, task);
        return db.insert(ToDoDatabaseHelper.TABLE_TODO, null, values);
    }

    // Method to retrieve all tasks
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        Cursor cursor = db.query(ToDoDatabaseHelper.TABLE_TODO,
                new String[]{ToDoDatabaseHelper.COLUMN_TASK},
                null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Use getColumnIndexOrThrow() to avoid deprecated method issues
                tasks.add(cursor.getString(cursor.getColumnIndexOrThrow(ToDoDatabaseHelper.COLUMN_TASK)));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return tasks;
    }

    // Method to close the database connection
    public void close() {
        db.close();
        dbHelper.close();
    }
}
