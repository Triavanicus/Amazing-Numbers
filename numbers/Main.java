package numbers;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Welcome to Amazing Numbers!");
    System.out.println();
    printSupportedRequests();

    while (true) {
      System.out.print("Enter a request: ");
      String[] answer = sc.nextLine().split(" ");
      System.out.println();

      if ("".equals(answer[0])) {
        printSupportedRequests();
        continue;
      }

      long number = -1;
      long sequence;

      try {
        number = Long.parseLong(answer[0]);
      } catch (NumberFormatException ignored) {
      }

      if (number == 0) {
        break;
      }

      if (!NumberInfo.isNatural(number)) {
        System.out.println("The first parameter should be a natural number or zero.");
        System.out.println();
        continue;
      }

      if (answer.length == 1) {
        NumberInfo.printProperties(number);
      } else {

        try {
          sequence = Long.parseLong(answer[1]);
        } catch (NumberFormatException e) {
          sequence = -1;
        }

        if (!NumberInfo.isNatural(sequence)) {
          System.out.println("The second parameter should be a natural number.");
          System.out.println();
          continue;
        }
        NumberInfo.printProperties(number, sequence);
      }
    }

    System.out.println("Goodbye!");
  }

  public static void printSupportedRequests() {
    System.out.println("Supported requests:");
    System.out.println("- enter a natural number to know its properties;");
    System.out.println("- enter two natural numbers to obtain the propterties of the list:");
    System.out.println("  * the first parameter represents a starting number;");
    System.out.println(
        "  * the second parameter shows how many consecutive numbers are to be processed;");
    System.out.println("- separate the parameters with one space;");
    System.out.println("- enter 0 to exit.");
    System.out.println();
  }
}
