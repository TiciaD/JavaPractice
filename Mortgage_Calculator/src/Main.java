import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
  public static void main(String[] args) {
    // set constant for num of months in a year
    final byte MONTHS_IN_YEAR = 12;
    // set constant for percent conversions to decimals
    final byte PERCENT = 100;
    // initialize principal
    int principal = 0;
    // initialize monthly interest
    float monthlyInterest = 0;
    // initialize number of payments
    int numOfPayments = 0;

    // initialize scanner to take user input
    Scanner scanner = new Scanner(System.in);

    while (true) {
      // Prompt user to input principal
      System.out.println("Principal: ");
      // set user input to principal variable
      principal = scanner.nextInt();
      if (principal >= 1000 && principal <= 1000000)
        break;
      System.out.println("Enter a value between 1000 and 1000000");
    }
    

    while (true) {
      // Prompt user to input Annual interest rate
      System.out.println("Annual Interest Rate: ");
      // set user input to annualInterest variable
      float annualInterest = scanner.nextFloat();
      if (annualInterest >= 1 && annualInterest <=30) {
        // convert annual interest to monthly interest and set to monthlyInterest variable
        monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        break;
      }
      System.out.println("Enter a value between 1 and 30");
    }

    while (true) {
      // Prompt user for years within that period
      System.out.println("Period (Years): ");
      // set user input to years variable
      byte years = scanner.nextByte(); // byte can hold up to 30
      if (years >= 1 && years <= 30) {
        // convert years to months and set to numOfPayments variable
        numOfPayments = years * MONTHS_IN_YEAR;
        break;
      }
      System.out.println("Enter a value between 1 and 30");
    }

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
