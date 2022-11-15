package numbers;

import numbers.properties.Buzz;
import numbers.properties.Duck;
import numbers.properties.Even;
import numbers.properties.Odd;
import numbers.properties.Palindrome;
import numbers.properties.Property;

public class NumberInfo {

  private static Property[] properties = {
      new Even(),
      new Odd(),
      new Buzz(),
      new Duck(),
      new Palindrome(),
  };

  public static boolean isNatural(long number) {
    return number > 0;
  }

  public static void printProperties(long number) {
    System.out.printf("Properties of %,d%n", number);
    for (Property p : properties) {
      printProperty(p.getName(), p.test(number));
    }
  }

  private static void printProperty(String name, boolean value) {
    System.out.printf("%12s: %b%n", name, value);
  }
}