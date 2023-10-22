package MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
	
	private static final int monthsInYear=12;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Principal Amount");
		double principal=sc.nextDouble();
		
		System.out.println("Enter the Annual interest Rate");
		float annualInterstRate=sc.nextFloat();
		
		System.out.println("Enter the term in years");
		int termInYears=sc.nextInt();
		
		float monthlyInterestRate=annualInterstRate / monthsInYear;
		float PerToRate=monthlyInterestRate/100;
		int numberOfPayments =termInYears * monthsInYear;
		
		double monthlyPayment=principal*((PerToRate*(Math.pow(PerToRate+1,numberOfPayments)))
				/
				((Math.pow(1+PerToRate, numberOfPayments))-1));
		
		System.out.println("Monthly payment : "+NumberFormat.getCurrencyInstance().format(monthlyPayment));
		
		System.out.println("Total Payment amount : "+NumberFormat.getCurrencyInstance().format(monthlyPayment*numberOfPayments));
		
	}
}
