package com.sandipbhattacharya.simplediceroller;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setBackgroundColor(Color.parseColor("#010b13"));
        Button buttonCreateAccount = findViewById(R.id.buttonCreateAccount);
        buttonCreateAccount.setBackgroundColor(Color.parseColor("#010b13"));
        Button buttonQuickPlay = findViewById(R.id.buttonQuickPlay);
        buttonQuickPlay.setBackgroundColor(Color.parseColor("#010b13"));

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                //Close the current activity
                finish();
            }
        });

        buttonQuickPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DiceActivity.class);
                startActivity(intent);
                //Close the current activity
                finish();
            }
        });

        buttonCreateAccount.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SensorActivity.class);
            startActivity(intent);
        });
    }
}