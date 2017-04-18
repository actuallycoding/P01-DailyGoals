package com.example.a15017484.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the button and set the OnClickListener
        Button btnOK = (Button) findViewById(R.id.button);
        btnOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //Get Q1
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                //Get Q2
                RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);
                //Get Q3
                RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);
                //Get RJ
                EditText etRJ = (EditText) findViewById(R.id.editTextReflection);
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
}
