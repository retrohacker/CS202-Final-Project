package com.awesomesauce.bmr;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.Intent;

/**
* @author William Blankenship
* @email william.jblankenship(at)gmail.com
* @date 11/12/11
*/
public class InputActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	//This code runs when the program is first started on the phone
        super.onCreate(savedInstanceState);
        //We set the layout of this activity to main.xml
        setContentView(R.layout.main);
        populateHints();
    }
    @Override
    protected void onStart() {
        super.onStart();
        populateHints();
    }
    @Override
    protected void onResume() {
    	/* This code is ran every time the activity resumes (I.E. you
    	 * return to this activity from another activity or application
    	 */
        super.onResume();
        populateHints();
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be
        //"paused").
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
    
    
    /**
     * This takes the user's input, calculates the BMI and BMR values,
     * then passes these values to a new activity that will display them.
     */
    public void showResult(View v)
    {
	Intent intent = new Intent(this, ResultActivity.class);
	
	/* The next lines will retrieve the users input from the main.xml
	 * layout file.*/
	EditText _weight = (EditText)findViewById(R.id.weightInput);
	EditText _age = (EditText)findViewById(R.id.ageInput);
	EditText _feet = (EditText)findViewById(R.id.feet);
	EditText _inches = (EditText)findViewById(R.id.inches);
	RadioButton _male = (RadioButton)findViewById(R.id.male);
	RadioButton _female = (RadioButton)findViewById(R.id.female);
	/* We set the default for all variables to 0 in case the user did not
	 * enter values into the form.
	 */
	int weight = 0;
	int age = 0;
	int gender = 0;
	int feet = 0;
	int inches = 0;
	
	//We check to make sure the user entered data then fill the variables
	if(_weight.getText().length() > 0)
	    weight = Integer.parseInt(_weight.getText().toString());
	if(_age.getText().length() > 0)
	    age = Integer.parseInt(_age.getText().toString());
	if(_male.isChecked())
	{
	    gender = 0;
	}
	else if(_female.isChecked())
	{
	    gender = 1;
	}
	if(_feet.getText().length() > 0)
	    feet = Integer.parseInt(_feet.getText().toString());
	if(_inches.getText().length() > 0)
	    inches = Integer.parseInt(_inches.getText().toString());
	/*End retrieving user's input*/
	
	/*We detect if the user has entered a metric unit or a US unit
	 * of measurement*/
	int height = 0;
	RadioButton metric = (RadioButton)findViewById(R.id.metric);
	if(metric.isChecked())
	{
	    /*If the unit is metric, we convert m to cm then add to cm
	     * then convert to inches. We also convert kg to lbs*/
	    height = (int) Math.ceil((feet*100+inches)*0.393700787);
	    weight = (int) Math.ceil(weight*2.20462262);
	}
	else
	{
		/* Otherwise we convert to feet to inches then add to the value of
		 * inches.
		 */
	    height= (feet*12) + inches;
	}
	
	//We then pass the user's input into the results activity
	intent.putExtra("weight", weight);
	intent.putExtra("age", age);
	intent.putExtra("gender", gender);
	intent.putExtra("height", height);
	startActivity(intent);
    }
    
    /**
     * Populates TextEdit hints that rely on user input
     */
    public void populateHints() {
    	/* We declare the metric RadioButton and _feet,_inches EditText
         * from main.xml so we can read and manipulate their values
         */
        RadioButton metric = (RadioButton)findViewById(R.id.metric);
        EditText _feet = (EditText)findViewById(R.id.feet);
        EditText _inches = (EditText)findViewById(R.id.inches);
        EditText _weight = (EditText)findViewById(R.id.weightInput);
	
        //We check to see if metric is checked
        if(metric.isChecked())
        {
        	//Set the hint of feet and inches to reflect the metric system
            _feet.setHint("M");
            _inches.setHint("CM");
    		_weight.setHint("Enter Weight in kg");
        }
        else
        {
        	//Set the hint of feet and inches to reflect the US system
            _feet.setHint("FT");
            _inches.setHint("IN");
    		_weight.setHint("Enter Weight in LBS");
        }
    }
    /**
     * The user is requesting to enter their height and weight in the U.S.
     * system.
     */
    public void toUS(View v) {
    	EditText _weight = (EditText)findViewById(R.id.weightInput);
		EditText _feet = (EditText)findViewById(R.id.feet);
		EditText _inches = (EditText)findViewById(R.id.inches);
		
		_feet.setHint("FT");
		_inches.setHint("IN");
		_weight.setHint("Enter Weight in LBS");
    }
    
    /**
     * The user is requesting to enter their height in weight in the
     * metric system.
     */
    public void toMetric(View v) {
		EditText _feet = (EditText)findViewById(R.id.feet);
		EditText _inches = (EditText)findViewById(R.id.inches);
		EditText _weight = (EditText)findViewById(R.id.weightInput);
		
		_feet.setHint("M");
		_inches.setHint("CM");
		_weight.setHint("Enter Weight in kg");
    }
}