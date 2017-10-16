package com.trainingtae.TareaDos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution {

	public int multiply(int numberOne, int numberTwo) {
		return numberOne*numberTwo;
	}

	public int substraction(int numberOne, int numberTwo) {
		return numberOne - numberTwo;		
	}

	
	public String concat(String wordOne, String wordTwo, String wordThree) {
		return wordOne.concat(wordTwo).concat(wordThree);
	}

	
	public String generateDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		Date date = cal.getTime();
		
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/mm/dd");
		return DATE_FORMAT.format(date);
		}			
}
