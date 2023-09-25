package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView welcome;
    EditText name;

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        welcome = findViewById(R.id.Welcome);

        save = findViewById(R.id.save);

        name = findViewById(R.id.name);

        Intent intent = getIntent();

        String value = intent.getStringExtra("email");

        welcome.setText("Xin chao, " + value +". Vui long nhap ten");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                intent.putExtra("name", MainActivity2.this.name.getText().toString());

                setResult(RESULT_OK, intent);

                finish();
            }
        });

    }
}