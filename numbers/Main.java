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
      String property;

      try {
        number = Long.parseLong(answer[0]);
      } catch (NumberFormatException ignored) {
      }

      if (number == 0) {
        break;
      }

      if (NumberInfo.isUnnatural(number)) {
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

        if (NumberInfo.isUnnatural(sequence)) {
          System.out.println("The second parameter should be a natural number.");
          System.out.println();
          continue;
        }

        if (answer.length == 2) {
          NumberInfo.printProperties(number, sequence);
        } else {
          property = answer[2].toLowerCase();
          if (!NumberInfo.properties.containsKey(property)) {
            System.out.printf("The property [%s] is wrong.%n", property.toUpperCase());
            System.out.printf("Available properties: %s%n",
                NumberInfo.properties.keySet().toString().toUpperCase());
            System.out.println();
            continue;
          }

          NumberInfo.findProperty(number, sequence, property);
        }
      }
    }

    System.out.println("Goodbye!");
  }

  public static void printSupportedRequests() {
    System.out.println("Supported requests:");
    System.out.println("- enter a natural number to know its properties;");
    System.out.println("- enter two natural numbers to obtain the properties of the list:");
    System.out.println("  * the first parameter represents a starting number;");
    System.out.println(
        "  * the second parameter shows how many consecutive numbers are to be printed;");
    System.out.println("- two natural numbers and a property to search for;");
    System.out.println("- separate the parameters with one space;");
    System.out.println("- enter 0 to exit.");
    System.out.println();
  }
}
