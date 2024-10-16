package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ToDoDAO toDoDAO;
    private EditText taskInput;
    private Button addButton;
    private Button showTasksButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoDAO = new ToDoDAO(this);
        taskInput = findViewById(R.id.taskInput);
        addButton = findViewById(R.id.addButton);
        showTasksButton = findViewById(R.id.showTasksButton);

        // Adding a task
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskInput.getText().toString();
                if (!task.isEmpty()) {
                    toDoDAO.addTask(task);
                    Toast.makeText(MainActivity.this, "Task added", Toast.LENGTH_SHORT).show();
                    taskInput.setText("");
                }
            }
        });

        // Showing all tasks
        showTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> tasks = toDoDAO.getAllTasks();
                for (String task : tasks) {
                    Toast.makeText(MainActivity.this, task, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        toDoDAO.close();
    }
}
