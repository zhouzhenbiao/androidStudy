package com.example.myapplication0001;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class TextViewActivity extends AppCompatActivity {

    private Button btn_back_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        btn_back_main = findViewById(R.id.btn_back_main);
        btn_back_main.setOnClickListener((View view) -> {
            Intent intent = new Intent(TextViewActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }
}
