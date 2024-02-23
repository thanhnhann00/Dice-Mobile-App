package com.sandipbhattacharya.simplediceroller;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SensorActivity extends AppCompatActivity {

    private static final String TAG = SensorActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        Log.d(TAG, "onCreate SensorActivity");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new SensorFragment())
                    .commit();
        }
    }
}
