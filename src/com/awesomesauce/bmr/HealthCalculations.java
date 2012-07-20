package com.awesomesauce.bmr;

/**
 * This class contains static method calls that deal with BMI and BMR
 * calculations
 *
 * @author William Blankenship
 * @date Nov 20, 2011
 * @email william.jblankenship(at)gmail.com
 */
public class HealthCalculations {
    
	/**
	 * Calculates a persons Body Mass Index 
	 * 
	 * @param weight
	 * The weight of the person
	 * @param height
	 * The height of the person in inches
	 * @return
	 * This function returns the BMI based on the values passed in
	 */
    public static double calcBMI(int weight, int height)
    {
	//BMI = ( Weight in Pounds / ( Height in inches x Height in inches ) ) x 703
	return ((double)weight / ((double)height*(double)height)) * 703.0;
    }
    
    /**
     * Calculates a persons BMR
     * 
     * @param weight
     * The weight of the person
     * @param age
     * The age of the person
     * @param height
     * The height of the person in inches
     * @param gender
     * The gender of the person (0=Male 1=Female)
     * @return
     * This function returns a double value representing the BMR of the
     * person
     */
    public static double calcBMR(int weight, int age, int height, int gender)
    {
	if(gender==0)
	    return 66+(6.23*weight)+(12.7*height)-(6.8*age);
	else
	    return 655+(4.35*weight)+(4.7*height)-(4.7*age);
    }
    
    /**
     * This function determines a person's weight class based on their BMI
     * value.
     * 
     * @param BMI
     * The BMI of the person being evaluated
     * @return
     * This function returns a string identifying the weight class of the
     * person.
     */
    public static String isOverweight(double BMI)
    {	
	if(BMI <= 18.5)
	    return "You are Under Weight";
	else if(BMI < 25)
	    return "You are Normal Weight";
	else if(BMI < 30)
	    return "You are Overweight";
	else if(BMI < 35)
	    return "You are (Class 1) Obese";
	else if(BMI < 40)
	    return "You are (Class 2) Obese";
	else
	    return "Morbidly Obese";
    }
    
    /**
     * Returns a description of the weight class a person belongs to based
     * on their BMI
     * 
     * @param BMI
     * The BMI of the person in question
     * @return
     * A string containing a description of the person's weight class
     */
    public static String diagnostic(double BMI)
    {
	if(BMI <= 18.5)
	    return "Your BMI indicates you may be underweight. Seek adv" +
    		"ice from a physician to see if you need to gain weight" +
    		".";
	else if(BMI < 25)
	    return "Your BMI indicates your weight is right were it sho" +
	    	"uld be.";
	else if(BMI < 30)
	    return "Your BMI indicates you are overweight. You would be" +
	    	"nefit from finding a healthy way to lower your overall" +
	    	" weight.";
	else if(BMI < 35)
	    return "You suffer from class 1 obesity. You are at risk fo" +
	    	"serious health problems. Consult your doctor and consi" +
	    	"der reducing your weight 5-10%.";
	else if(BMI < 40)
	    return "You suffer from class 2 obesity. You are at serious" +
	    	" risk for having major health problems. You should seek" +
	    	" medical help. A life style change would be w" +
	    	"ise.";	
	else
	    return "You are morbidly obese. Put down the droid and imme" +
	    	"diately contact your doctor. You need IMMEDIATE MEDICA" +
	    	"L ATTENTION. More then likely you suffer from a medica" +
	    	"l condition that has gone untreated. We wish you the b" +
	    	"est. God Speed.";
    }
    
    /**
     * This function generates a string of symptoms a person with a
     * specific BMI may experience.
     * 
     * @param BMI
     * The BMI of the person
     * @return
     * This function returns a string containing a list of symptoms
     */
    public static String symptoms(double BMI)
    {
	String answer = "Possible Symptoms:\n";
	if(BMI <= 18.5)
	{
	    answer += "Lower Immune System\nDissapeara" +
    		"ance of Periods in women\nBone Loss\nMalnutrition\n\nT" +
    		"he lower your BMI the greater your risk of developing " +
    		"side effects.";
	}
	else if(BMI < 25)
	{
	    answer += "Good Health\nExcessive Happiness\nThe unexplai" +
	    		"nable urge to save random kittens from trees";
	}
	if(BMI >= 25)
	{
	    answer += "High Blood Pressure\nDiabetes\nHeart Disease";
	}
	if(BMI >= 30)
	{	    
	    answer += "\nDiabetes\nGall Bladder Disease\nCancer";
	}
	if(BMI >= 35)
	{
	    answer += "\nHeart Failure\nDEATH";
	}
	return answer;
    }

    /**
     * This function determines a treatment plan for someone with a
     * specific BMI
     * 
     * @param BMI
     * The BMI of the person
     * @return
     * A string containing treatment options for the patient
     */
    public static String treatment(double BMI)
    {
	if(BMI <= 18.5)
	    return "Treatment:\nYou need to put on weight, however you " +
	    	"need to be cautious and not gain weight in the form of" +
	    	" excess fat. Increase your calorie intake and begin a w" +
	    	"orkout routine that will help convert those calories i" +
	    	"nto muscle instead of fat. A good target for weight ga" +
	    	"in is generally 1/2 pound per week, however this varie" +
	    	"s between individuals.\n\nTips:\nIncrease Calorie Inta" +
	    	"ke\nStick to an Excersise Routine\nDrink 6-8 Glasses o" +
	    	"f water a day\nEat Frequent small meals instead of 3 l" +
	    	"arge meals per day";
	else if(BMI < 25)
	    return "";
	else if(BMI < 30)
	    return "Treatment:\nSet a goal of loosing about 4-8 pounds " +
	    	"per month. Consume less calories then your BMR recomme" +
	    	"nds to loose weight. Do not overdue this, the less you" +
	    	" eat, the lower your BMR becomes. Starving yourself wil" +
	    	"l only cause malnutrition and make loosing weight hard" +
	    	"er. Increasing your daily physical activity will burn " +
	    	"additional calories making weight loss easier.\n\nTips" +
	    	":\nCut red meats out of your diet.\nGet your protein f" +
	    	"rom fish and poultry\nDo not consume fried or greasy f" +
	    	"oods\nEat a salad before your meal, this will help you" +
	    	" keep your portion size small\nDo not drink sugary drin" +
	    	"ks\nDrink eight glasses of water per day";
	else
	    return "Treatment:\nTreatment will involve a combination of" +
	    	" exercise, diet, lifestyle change, and sometimes even w" +
	    	"eight loss drugs depending on the severity of the obes" +
	    	"ity. Your goal should be to loose rougly 1-2 pounds pe" +
	    	"r week to prevent loosing muscle mass instead of fat. " +
	    	"\n\nTips\nSeek advice from a doctor or specialist\nHav" +
	    	"e at least 30 minutes of physical activity per day"+
	    	"\nCut red meats out of your diet.\nGet your protein f" +
	    	"rom fish and poultry\nDo not consume fried or greasy f" +
	    	"oods\nEat a salad before your meal, this will help you" +
	    	" keep your portion size small\nDo not drink sugary drin" +
	    	"ks\nDrink eight glasses of water per day";
    }
}
