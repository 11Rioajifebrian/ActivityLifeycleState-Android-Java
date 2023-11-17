package com.rio.activitylifeyclestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ageEditText;
    TextView yearTextView;
    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MAIN ACTIVITY","CREATED");
        ageEditText = findViewById(R.id.ageET);
        yearTextView = findViewById(R.id.yearTV);
        if (savedInstanceState !=null) {
            year = savedInstanceState.getInt("YEAR_KEY");
            yearTextView.setText(String.valueOf(year));
        }
    }
    public void calculateYear(View view) {
        String ageInString = ageEditText.getText().toString();
        year = ageToYear(Integer.valueOf(ageInString));
        yearTextView.setText(String.valueOf(year));
    }

    private int ageToYear(int age){
        return 2023 - age;
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("YEAR_KEY", year);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MAIN ACTIVITY","STARTED");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MAIN ACTIVITY","RESUMED");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MAIN ACTIVITY","PAUSED");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MAIN ACTIVITY","STOPPED");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MAIN ACTIVITY","DESTROYED");
    }
}