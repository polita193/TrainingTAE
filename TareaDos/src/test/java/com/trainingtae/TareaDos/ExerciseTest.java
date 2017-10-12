package com.trainingtae.TareaDos;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExerciseTest {
	
	Solution solution= new Solution();

	@Test(dataProvider="getNumbers", groups = {"Smoke", "Regression"} )
	public void multiplication(int numberOne, int numberTwo){
		int resultado = solution.multiply(numberOne, numberTwo);
		System.out.println("Operation :"+numberOne+" X "+numberTwo+" = "+resultado);
	}
	

	@Test(dataProvider="getWords", groups = {"Smoke"})
	public void concatWords(String wordOne, String wordTwo, String wordThree){
		
		String wordResult = "";
		wordResult = solution.concat(wordOne, wordTwo, wordThree);
		System.out.println("Word Result: "+wordResult);
		
	}
	
	
	@Parameters({"year", "month", "day"})
	@Test(groups = {"Smoke"})
	public void generateDate(int year, int month, int day){
	   	String date = solution.generateDate(year, month, day);
		System.out.println("The date is: "+date);
	}
	
	
	@Parameters({"key", "numberOne", "numberTwo"})
	@Test(groups = {"Smoke", "Regression"})
	public void operationByAmbiente(String key, int numberOne, int numberTwo){
		int result = 0;
		if(key.equals("AMBIENTE1")){
			result = solution.multiply(numberOne, numberTwo);
		}else if(key.equals("AMBIENTE2")){
			result = solution.substraction(numberOne, numberTwo);
		}
		Assert.assertEquals(result, 10);
		Assert.assertEquals(key, "AMBIENTE2");
		System.out.println("For "+key+" the result is "+result);
	}
	
	
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Class");
	}
	
	@BeforeGroups
	public void beforeGroups(){
		System.out.println("Before Groups");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("After Method");
	}
	
	@AfterGroups
	public void afterGroups(){
		System.out.println("After Groups");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("After Class");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("After Suite");
	}
	
	
	@DataProvider(name="getNumbers")
	private Object[][] getNumbers(){
		return new Object[][]{{new Integer(24), new Integer(5)}, 
							  {new Integer(16), new Integer(43)}, 
							  {new Integer(37), new Integer(12)}};														
	}
	
	@DataProvider(name="getWords")
	private Object[][] getWords(){
		return new Object[][]{{"Computador", "nuevo", "Dell"}, 
							  {"Anita", "lava", "la"}, 
							  {"Es", "un", "Palindromo"},
							  {"Uno", "Dos", "ocho"}};														
	}
	
}
