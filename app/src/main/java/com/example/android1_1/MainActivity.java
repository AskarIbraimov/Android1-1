package com.example.android1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2, et3;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inits();

        checks();
    }

    private void checks() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().equals("")
                        || et2.getText().toString().equals("")
                        || et3.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Заполни поля! motherfucker! ", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message");
                    intent.setPackage("com.google.android.gm");
                    intent.putExtra(Intent.EXTRA_TEXT, et3.getText().toString());
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{et1.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, et2.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }


    private void inits() {
        et1 = findViewById(R.id.et_email);
        et2 = findViewById(R.id.et_theme);
        et3 = findViewById(R.id.et_text);
        btnSend = findViewById(R.id.btn_send);
    }
}