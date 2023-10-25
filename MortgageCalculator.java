package MortgageCalculator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class MortgageCalculator {
	
	private static final int monthsInYear=12;
	private static final int constant =100;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter '1' for Interest rate percentage to rupee :");
		System.out.println("Enter '2' for Interest rate rupee to  presentage :");
		System.out.println("Enter '3' for find Simple Interest");
		System.out.println("Enter '4' for find Compound interest" );
		System.out.println("Enter '5' for Monthly EMI :");
		int n=sc.nextInt();
		if (n==1){
		System.out.println("Enter '1' for Interest rate presentage to rupee :");
		System.out.println("Enter the presentage ");
		float precent=sc.nextFloat();
		float Rupee  =precent/monthsInYear;
		System.out.println("interest value in rupee :   "+NumberFormat.getCurrencyInstance().format(Rupee));
		}
		
		if(n==2){
			System.out.println("Enter the Rupee");
			float Rs=sc.nextFloat();
			float pre =Rs*monthsInYear;

			System.out.printf("Rs: %.2f Interest rate in percentage : %.2f%%", Rs,pre);
		}
		
		
		if (n==3){
			
			System.out.println("Enter the Principal Amount");
			double principal=sc.nextDouble();
			System.out.println("Enter the Annual interest Rate in rupee");
			float annualInterstRate=sc.nextFloat();
			System.out.println("Enter Doubt taken Date");
			System.out.println("Enter Year : ");
			int y1=sc.nextInt();
			System.out.println("Enter month in number : ");
			int m1=sc.nextInt();
			System.out.println("Enter day : ");
			int d1=sc.nextInt();
			LocalDate day1= LocalDate.of(y1,m1,d1);
			
			System.out.println("Doubt retain Date");
			System.out.println("Enter Year : ");
			int y2=sc.nextInt();
			System.out.println("Enter month in number : ");
			int m2=sc.nextInt();
			System.out.println("Enter day : ");
			int d2=sc.nextInt();
			LocalDate day2= LocalDate.of(y2,m2,d2);
			int months=0;
			Period period=Period.between(day1,day2); 
			System.out.println("Difference between two Dates");
			System.out.println(period.getYears()+" years "+period.getMonths()+" months "+period.getDays()+" Days");
			int month=period.getYears()*monthsInYear;		
			int days=period.getDays();
			if (days<15){
			months=month+period.getMonths();
			}
			else{
				months=month+period.getMonths()+1;	
			}
			System.out.println("Total months between two Dates : "+months+" months");
		
		float onlyInterset=(float)(principal*annualInterstRate*months)/constant ;
		double total=(double)principal+onlyInterset;
		
		System.out.println("Interest for  "+NumberFormat.getCurrencyInstance().format(principal)+"  is : "+NumberFormat.getCurrencyInstance().format(onlyInterset));
		System.out.println("Total amount with interest : "+NumberFormat.getCurrencyInstance().format(total));
		}
	
		if(n==4){
			System.out.println("Enter the Principal Amount");
			double principal = sc.nextDouble();
			double prin = principal;
			System.out.println("Enter the Annual interest Rate in rupee");
			float annualInterstRate = sc.nextFloat();
			System.out.println("Enter Doubt taken Date");
			System.out.println("Enter Year : ");
			int y1 = sc.nextInt();
			System.out.println("Enter month in number : ");
			int m1 = sc.nextInt();
			System.out.println("Enter day : ");
			int d1 = sc.nextInt();
			LocalDate day1 = LocalDate.of(y1, m1, d1);

			System.out.println("Doubt retain Date");
			System.out.println("Enter Year : ");
			int y2 = sc.nextInt();
			System.out.println("Enter month in number : ");
			int m2 = sc.nextInt();
			System.out.println("Enter day : ");
			int d2 = sc.nextInt();
			LocalDate day2 = LocalDate.of(y2, m2, d2);
			int months = 0;
			Period period = Period.between(day1, day2);
			System.out.println("Difference between two Dates");
			System.out.println(period.getYears() + " years " + period.getMonths()
					+ " months " + period.getDays() + " Days");
			int y = period.getYears();
			int m = period.getMonths();
			int d = period.getDays();
			System.out.println(m);
			int month = period.getYears() * 12;

			System.out.println(month);
			int days = period.getDays();
			if (days < 15) {
				months = month + period.getMonths();
			} else {
				months = month + period.getMonths() + 1;
			}
			System.out.println("Total months between two Dates : " + months
					+ " months");
			float onlyInterest = 0;
			double total = 0;
			double mtotal = 0;
			double T = 0;
			for (int i = 1; i <= y; i++) {
				total = (float) (principal * 12 * annualInterstRate) / 100;
				principal = (double) principal + total;

			}

			if (m >= 1 && m < 12) {

				mtotal = (float) (principal * annualInterstRate * m) / 100;
				T = (double) principal + mtotal;

			}
			total = total + T;
			System.out.println("Taken Debt "
					+ NumberFormat.getCurrencyInstance().format(prin));
			System.out.println("Compound Interest for Taken Debt "
					+ NumberFormat.getCurrencyInstance().format(total));
			System.out.println("Interest added to your Debt "
					+ NumberFormat.getCurrencyInstance().format(total - prin));

		
		}
		
		
		if (n==5){
		System.out.println("Enter the Principal Amount");
		double principal=sc.nextDouble();
		
		System.out.println("Enter the Annual interest Rate");
		float annualInterstRate=sc.nextFloat();
		
		System.out.println("Enter the term in years");
		int termInYears=sc.nextInt();
		
		float monthlyInterestRate=annualInterstRate / monthsInYear;
		float PerToRate=monthlyInterestRate/constant;
		int numberOfPayments =termInYears * monthsInYear;
		
		double monthlyPayment=principal*((PerToRate*(Math.pow(PerToRate+1,numberOfPayments)))
				/
				((Math.pow(1+PerToRate, numberOfPayments))-1));
		
		System.out.println("Monthly payment : "+NumberFormat.getCurrencyInstance().format(monthlyPayment));
		
		System.out.println("Total Payment amount : "+NumberFormat.getCurrencyInstance().format(monthlyPayment*numberOfPayments));
		}
	}
}
