package com.cristinashuw.passdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    Button buttonSave, buttonDetail;
    SharedPreferences sp;
    String nameStr, emailStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText_name);
        email = findViewById(R.id.editText_email);
        buttonSave = findViewById(R.id.buttonSave);
        buttonDetail = findViewById(R.id.buttonDetail);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameStr = name.getText().toString();
                emailStr = email.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("name", nameStr);
                editor.putString("email", emailStr);
                editor.commit();
                Toast.makeText(MainActivity.this, "Information Saved.", Toast.LENGTH_LONG).show();

            }
        });

        buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailPage.class);
                startActivity(intent);
            }
        });
    }
}