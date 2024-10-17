package com.example.taskmaster;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ToDoAdapter extends BaseAdapter {
    private ArrayList<ToDoItem> todoList;

    public ToDoAdapter(ArrayList<ToDoItem> todoList) {
        this.todoList = todoList;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int position) {
        return todoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item_layout, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.textView);
        ToDoItem todoItem = todoList.get(position);

        textView.setText(todoItem.getTask());

        if (todoItem.isUrgent()) {
            convertView.setBackgroundColor(Color.RED);
            textView.setTextColor(Color.WHITE);
        } else {
            convertView.setBackgroundColor(Color.WHITE);
            textView.setTextColor(Color.BLACK);
        }

        return convertView;
    }
}
