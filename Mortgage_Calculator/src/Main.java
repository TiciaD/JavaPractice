import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
  // set constant for num of months in a year
  final static byte MONTHS_IN_YEAR = 12;
  // set constant for percent conversions to decimals
  final static byte PERCENT = 100;
  public static void main(String[] args) {
      // Prompt user to input principal
      int principal = (int) readNumber("Principal: ", 1000, 1000000);
      // Prompt user to input Annual interest rate
      float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
      // Prompt user for years within that period
      byte years = (byte) readNumber("Period (Years): ", 1, 30);

      printMortgage(principal, annualInterest, years);
      printPaymentSchedule(principal, annualInterest, years);
    }

    public static double readNumber(String prompt, double min, double max) {
      // initialize scanner to take user input
      Scanner scanner = new Scanner(System.in);
      double value;
      while (true) {
        // Prompt user to input
        System.out.println(prompt);
        // set user input to value variable
        value = scanner.nextInt();
        if (value >= min && value <= max)
          break;
        System.out.println("Enter a value between " + min + " and " + max);
      }
      return value;
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short numOfPaymentsMade) {
      // convert annual interest to monthly interest and set to monthlyInterest variable
      float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
      // convert years to months and set to numOfPayments variable
      short numOfPayments = (short)(years * MONTHS_IN_YEAR);

      // calculate total balance based on user inputs
      double balance = principal 
                      * (Math.pow(1 + monthlyInterest, numOfPayments) - Math.pow(1 + monthlyInterest, numOfPaymentsMade)) 
                      / (Math.pow(1 + monthlyInterest, numOfPayments) - 1);

      return balance;
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
      // convert annual interest to monthly interest and set to monthlyInterest variable
      float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
      // convert years to months and set to numOfPayments variable
      short numOfPayments = (short)(years * MONTHS_IN_YEAR);

      // calculate mortgage based on user inputs
      double mortgage = principal 
      * (monthlyInterest * Math.pow(1 + monthlyInterest, numOfPayments))
      / (Math.pow(1 + monthlyInterest, numOfPayments) - 1);
      return mortgage;
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
      // calculate mortgage based on user inputs
      double mortgage = calculateMortgage(principal, annualInterest, years);

      // format mortgage calculation to a currency and convert to string
      String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
      // styling
      System.out.println();
      System.out.println("MORTGAGE");
      System.out.println("---------");
      // output mortgage calculation
      System.out.println("Monthly Payment: " + formattedMortgage);
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
      System.out.println();
      System.out.println("PAYMENT SCHEDULE");
      System.out.println("-----------------");
      // loop over months in a year for user input amount of years
      for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
        // calculate balance for each month
        double balance = calculateBalance(principal, annualInterest, years, month);
        // format balance calculation to a currency and convert to string
        System.out.println(NumberFormat.getCurrencyInstance().format(balance));
      }
    }
}
