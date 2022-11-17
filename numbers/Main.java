package numbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  private static boolean running;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    running = true;

    System.out.println("Welcome to Amazing Numbers!");
    System.out.println();
    printSupportedRequests();

    while (running) {
      System.out.print("Enter a request: ");
      String[] answer = sc.nextLine().split(" ");
      System.out.println();

      if ("".equals(answer[0])) {
        printSupportedRequests();
        continue;
      }

      int parameterCount = answer.length;
      switch (parameterCount) {
        case 1 -> run1(answer);
        case 2 -> run2(answer);
        case 3 -> run3(answer);
        default -> run4(answer);
      }
    }

    System.out.println("Goodbye!");
  }


  public static void run1(String[] args) {
    long number = getNumber(args[0]);
    if (number == 0) {
      running = false;
      return;
    }
    if (isFirstNatural(number)) {
      NumberInfo.printProperties(number);
    }
  }

  public static void run2(String[] args) {
    long number = getNumber(args[0]);
    long count = getNumber(args[1]);
    if (isFirstNatural(number) && isSecondNatural(count)) {
      NumberInfo.printProperties(number, count);
    }
  }

  public static void run3(String[] args) {
    long number = getNumber(args[0]);
    long count = getNumber(args[1]);
    String property = args[2];
    if (isFirstNatural(number) && isSecondNatural(count) && propertiesExists(
        new String[]{property})) {
      NumberInfo.findProperty(number, count, property);
    }
  }

  public static void run4(String[] args) {
    long number = getNumber(args[0]);
    long count = getNumber(args[1]);
    String[] searchNames = Arrays.copyOfRange(args, 2, args.length);
    if (isFirstNatural(number) && isSecondNatural(count) && propertiesExists(searchNames)) {
      String[] conflicts = NumberInfo.getConflictingProperties(searchNames);
      if (conflicts.length > 0) {
        System.out.printf("The request contains mutually exclusive properties: [%s]%n",
            String.join(", ", conflicts).toUpperCase());
        System.out.println("There are no numbers with these properties.");
        System.out.println();
        return;
      }

      NumberInfo.findProperties(number, count, searchNames);
    }
  }

  private static boolean isFirstNatural(long number) {
    if (NumberInfo.isUnnatural(number)) {
      System.out.println("The first parameter should be a natural number or zero.");
      System.out.println();
      return false;
    }
    return true;
  }

  private static boolean isSecondNatural(long number) {
    if (NumberInfo.isUnnatural(number)) {
      System.out.println("The second parameter should be a natural number.");
      System.out.println();
      return false;
    }
    return true;
  }

  private static boolean propertiesExists(String[] properties) {
    StringBuilder sb = new StringBuilder();
    int numProperties = 0;
    for (String property : properties) {
      if (!NumberInfo.getProperties().containsKey(property.toLowerCase())) {
        if (sb.length() > 0) {
          sb.append(", ");
        }
        sb.append(property.toUpperCase());
        numProperties++;
      }
    }

    if (sb.length() > 0) {
      if (numProperties == 1) {
        System.out.printf("The property [%s] is wrong.%n", sb);
      } else {
        System.out.printf("The properties [%s] are wrong.%n", sb);
      }
      System.out.printf("Available properties: %s%n",
          NumberInfo.getProperties().keySet().toString().toUpperCase());
      System.out.println();
      return false;
    }
    return true;
  }

  private static long getNumber(String arg) {
    long number;
    try {
      number = Long.parseLong(arg);
    } catch (NumberFormatException e) {
      number = -1;
    }
    return number;
  }

  public static void printSupportedRequests() {
    System.out.println("Supported requests:");
    System.out.println("- enter a natural number to know its properties;");
    System.out.println("- enter two natural numbers to obtain the properties of the list:");
    System.out.println("  * the first parameter represents a starting number;");
    System.out.println(
        "  * the second parameter shows how many consecutive numbers are to be printed;");
    System.out.println("- two natural numbers and two properties to search for;");
    System.out.println("- a property preceded by minus must not be present in numbers;");
    System.out.println("- separate the parameters with one space;");
    System.out.println("- enter 0 to exit.");
    System.out.println();
  }
}
