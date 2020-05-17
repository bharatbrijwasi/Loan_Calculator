package loanCalculator;
import java.util.*;
import java.text.*;
public class DriverClass 
{
	public static void main(String[] args) 
	{
		final int MONTHS_IN_YEAR = 12;
		double loanAmount;
		int loanPeriod;
		double annualInterestRate;
		double monthlyPayment;
		double totalPayment;
		double monthlyInterestRate;
		int numberOfPayments;
		
		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.println("This Program computes the monthly and total");
		System.out.println("payments for a given loan amount, annual ");
		System.out.println("interest rate, and loan period.");
		System.out.println("Loan amount in dollars and cents, e.g. 123456.20");
		System.out.println("Annual interest rate in percentage, e.g. 12.50");
		System.out.println("Loan Period in number of years, e.g. 15");
		System.out.println("---------+------------+-------------");
		
		System.out.println("Loan Amount (in rupees): ");
		loanAmount = scanner.nextDouble();
		System.out.println("Annual Interest Rate(e.g., 9.5): ");
		annualInterestRate = scanner.nextDouble();
		System.out.println("Loan Period -# of years: ");
		loanPeriod = scanner.nextInt();
		
		//compute the monthly and total payments
		monthlyInterestRate = annualInterestRate/MONTHS_IN_YEAR/100;
		numberOfPayments = loanPeriod * MONTHS_IN_YEAR;
		
		monthlyPayment = (loanAmount * monthlyInterestRate)/
							(1-Math.pow(1/(1 + monthlyInterestRate),
									numberOfPayments));
		
		totalPayment = monthlyPayment * numberOfPayments;
		
		//display the result
		System.out.println("------+---------+--------------");
		System.out.println("Monthly Payments: " +df.format(monthlyPayment));
		System.out.println("Total payments: " +df.format(totalPayment));
	}

}
