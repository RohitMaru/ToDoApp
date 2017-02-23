package com.mycompany.home.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String value = getIntent().getStringExtra("toDoItemName");
        position = getIntent().getIntExtra("toDoItemIndex", -1);
        TextView textView = (TextView) findViewById(R.id.todoEditText);
        textView.setText(value);
    }

    public void saveAction(View view) {
        Intent data = new Intent();
        TextView textView = (TextView) findViewById(R.id.todoEditText);
        Log.d("mytag", "saveAction: "+textView.getText() + " , index: "+position);
        data.putExtra("toDoItemValue", ""+textView.getText());
        data.putExtra("toDoItemIndex", position);
        setResult(RESULT_OK, data);
        finish();
    }


}
