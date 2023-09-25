package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText gmail;

    TextView label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.Login);

        gmail = findViewById(R.id.gmail);

        label = findViewById(R.id.Label);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = MainActivity.this.gmail.getText().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("email",value);

                OpenActivity2(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == RESULT_OK){
            gmail.setText(data.getStringExtra("name").toString());

            login.setVisibility(View.GONE);

            label.setText("Hen gap lai");
        }
    }

    public void OpenActivity2(Intent i){
        startActivityForResult(i,1234);
    }
}