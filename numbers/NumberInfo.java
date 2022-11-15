package numbers;

import numbers.properties.Buzz;
import numbers.properties.Duck;
import numbers.properties.Even;
import numbers.properties.Gapful;
import numbers.properties.Odd;
import numbers.properties.Palindrome;
import numbers.properties.Property;

public class NumberInfo {

  private static final Property[] properties = {
      new Even(),
      new Odd(),
      new Buzz(),
      new Duck(),
      new Palindrome(),
      new Gapful(),
  };

  public static boolean isNatural(long number) {
    return number > 0;
  }

  public static void printProperties(long number) {
    System.out.printf("Properties of %,d%n", number);
    for (Property p : properties) {
      printProperty(p.getName(), p.test(number));
    }
    System.out.println();
  }

  public static void printProperties(long number, long sequence) {
    long endNumber = number + sequence;
    for (long i = number; i < endNumber; i++) {
      String props = "";
      for (Property p : properties) {
        if (p.test(i)) {
          props = props.concat(p.getName() + " ");
        }
      }
      props = String.join(", ", props.split(" "));
      System.out.printf("%14s is %s%n", i, props);
    }
    System.out.println();
  }

  private static void printProperty(String name, boolean value) {
    System.out.printf("%12s: %b%n", name, value);
  }
}