package com.example.a15017484.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioGroup rg2;
    RadioGroup rg3;
    EditText etRJ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the button and set the OnClickListener
        Button btnOK = (Button) findViewById(R.id.button);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
        etRJ = (EditText) findViewById(R.id.editTextReflection);
        btnOK.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor prefEdit = prefs.edit();
                //Get Q1
                int selectedButtonId = rg.getCheckedRadioButtonId();
                prefEdit.putInt("q1", selectedButtonId);
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                //Get Q2

                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                prefEdit.putInt("q2", selectedButtonId2);
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);
                //Get Q3
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                prefEdit.putInt("q3", selectedButtonId3);
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);
                //Get RJ
                prefEdit.putString("rj", etRJ.getText().toString());
                prefEdit.commit();
                // Put the name and age into an array
                String[] info = {rb.getText().toString(),
                        rb2.getText().toString(),
                        rb3.getText().toString(),
                        etRJ.getText().toString()};
                // Create an intent to start another activity called
                //  DemoActivities (which we would create later)
                Intent i = new Intent(MainActivity.this,
                        SummaryActivity.class);
                // Pass the String array holding the name & age to new activity
                i.putExtra("info", info);
                // Start the new activity
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String rj = prefs.getString("rj","");
        int q1ID = prefs.getInt("q1",0);
        int q2ID = prefs.getInt("q2",0);
        int q3ID = prefs.getInt("q3",0);
        etRJ.setText(rj);
        rg.check(q1ID);
        rg2.check(q2ID);
        rg3.check(q3ID);
    }
}
