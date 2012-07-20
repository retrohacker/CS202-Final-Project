package com.awesomesauce.bmr;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * This class controls that activity that displays the Health Results
 * based on the data received from InputActivity.java
 * 
 * @author William Blankenship
 * @date Nov 18, 2011
 * @email william.jblankenship(at)gmail.com
 */
public class ResultActivity extends Activity{
    
    /**
     * Global Variables used to store the BMI and BMR rates
     */
    TextView bmiString;
    TextView bmrString;
    TextView weightAnalasys;
    TextView weightClass;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.result);
	
	//Extras will receive all data passed from the previous activity
	Bundle extras = getIntent().getExtras();
	
	int weight = extras.getInt("weight");
	int age = extras.getInt("age");
	int gender = extras.getInt("gender");
	int height = extras.getInt("height");

	DecimalFormat f = new DecimalFormat("#.####");
	
	bmiString = (TextView)findViewById(R.id.bmi);
	String bmi = f.format(HealthCalculations.calcBMI(weight, height));
	bmiString.setText(bmi);
	
	bmrString = (TextView)findViewById(R.id.bmr);
	String bmr = f.format(HealthCalculations.calcBMR(weight, age, height, gender));
	bmrString.setText(bmr);
	
	weightClass = (TextView)findViewById(R.id.weightClass);
	weightClass.setText(HealthCalculations.isOverweight(Double.parseDouble(bmi)));
	
	weightAnalasys = (TextView)findViewById(R.id.weightAnalasys);
	String diagnosis = HealthCalculations.diagnostic(Double.parseDouble(bmi)) +
		"\n\n"+ HealthCalculations.symptoms(Double.parseDouble(bmi)) +
		"\n\n" + HealthCalculations.treatment(Double.parseDouble(bmi));
	weightAnalasys.setText(diagnosis);
	
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
    }
    
    public void exitResults(View V) {
	finish();
    }
}
