import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
  public static void main(String[] args) {
    // set constant for num of months in a year
    final byte MONTHS_IN_YEAR = 12;
    // set constant for percent conversions to decimals
    final byte PERCENT = 100;

    // initialize scanner to take user input
    Scanner scanner = new Scanner(System.in);

    // Prompt user to input principal
    System.out.println("Principal: ");
    // set user input to principal variable
    int principal = scanner.nextInt();

    // Prompt user to input Annual interest rate
    System.out.println("Annual Interest Rate: ");
    // set user input to annualInterest variable
    float annualInterest = scanner.nextFloat();
    // convert annual interest to monthly interest and set to monthlyInterest variable
    float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

    // Prompt user for years within that period
    System.out.println("Period (Years): ");
    // set user input to years variable
    byte years = scanner.nextByte(); // byte can hold up to 30
    // convert years to months and set to numOfPayments variable
    int numOfPayments = years * MONTHS_IN_YEAR;

    // calculate mortgage based on user inputs
    double mortgage = principal 
      * (monthlyInterest * Math.pow(1 + monthlyInterest, numOfPayments))
      / (Math.pow(1 + monthlyInterest, numOfPayments) - 1);

    // format mortgage calculation to a currency and convert to string
    String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
    // output mortgage calculation
    System.out.println("Mortgage: " + formattedMortgage);
  }
}
