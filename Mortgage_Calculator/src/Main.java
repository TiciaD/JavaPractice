import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
  public static void main(String[] args) {
      // Prompt user to input principal
      int principal = (int) readNumber("Principal: ", 1000, 1000000);
      // Prompt user to input Annual interest rate
      float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
      // Prompt user for years within that period
      byte years = (byte) readNumber("Period (Years): ", 1, 30);

      // calculate mortgage based on user inputs
      double mortgage = calculateMortgage(principal, annualInterest, years);

      // format mortgage calculation to a currency and convert to string
      String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
      // output mortgage calculation
      System.out.println("Mortgage: " + formattedMortgage);
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

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
      // set constant for num of months in a year
      final byte MONTHS_IN_YEAR = 12;
      // set constant for percent conversions to decimals
      final byte PERCENT = 100;

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
}
