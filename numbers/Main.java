package numbers;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Welcome to Amazing Numbers!");
    System.out.println("Supported requests:");
    System.out.println("- enter a natural number to know it's properties;");
    System.out.println("- enter 0 to exit.");
    System.out.println();

    while (true) {
      System.out.print("Enter a request: ");
      String answer = sc.nextLine();
      System.out.println();

      long number = Long.parseLong(answer);

      if (number == 0) {
        break;
      }

      if (!NumberInfo.isNatural(number)) {
        System.out.println("The first parameter should be a natural number or zero.");
        System.out.println();
        continue;
      }

      NumberInfo.printProperties(number);
      System.out.println();
    }

    System.out.println("Goodbye!");
  }
}
