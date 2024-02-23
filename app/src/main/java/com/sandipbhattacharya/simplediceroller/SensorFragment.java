package com.sandipbhattacharya.simplediceroller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SensorFragment extends Fragment implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private TextView textViewX, textViewY, textViewZ;

    private static final String TAG = SensorFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView SensorFragment");
        return inflater.inflate(R.layout.fragment_sensor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Initialize SensorManager
        sensorManager = (SensorManager) requireActivity().getSystemService(Context.SENSOR_SERVICE);

        //Get the accelerometer sensor
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        if (accelerometer == null) {
            //Handle the case where the device doesn't have a linear accelerometer
            String errorMessage = "Error: This device does not have the appropriate sensor: Linear Accelerometer";
            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show();
        }

        // Find TextView elements
        textViewX = view.findViewById(R.id.textViewX);
        textViewY = view.findViewById(R.id.textViewY);
        textViewZ = view.findViewById(R.id.textViewZ);

        Log.d(TAG, "onViewCreated SensorFragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume SensorFragment");
        //Register the sensor listener
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause SensorFragment");
        //Unregister the sensor listener to save power when the fragment is not active
        sensorManager.unregisterListener(this);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onSensorChanged(SensorEvent event) {
        float xAcceleration = event.values[0];
        float yAcceleration = event.values[1];
        float zAcceleration = event.values[2];

        //Update TextView elements with accelerometer values
        textViewX.setText(String.format("X-Axis: %.2f", xAcceleration));
        textViewY.setText(String.format("Y-Axis: %.2f", yAcceleration));
        textViewZ.setText(String.format("Z-Axis: %.2f", zAcceleration));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}