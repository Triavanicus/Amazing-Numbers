package numbers;

import java.util.Map;
import numbers.properties.Buzz;
import numbers.properties.Duck;
import numbers.properties.Even;
import numbers.properties.Gapful;
import numbers.properties.Odd;
import numbers.properties.Palindrome;
import numbers.properties.Property;
import numbers.properties.Spy;

public class NumberInfo {

  public static final Map<String, Property> properties;

  static {
    properties = Map.of(
        "even", new Even(),
        "odd", new Odd(),
        "buzz", new Buzz(),
        "duck", new Duck(),
        "palindromic", new Palindrome(),
        "gapful", new Gapful(),
        "spy", new Spy());
  }

  public static boolean isUnnatural(long number) {
    return number < 1;
  }

  public static void printProperties(long number) {
    System.out.printf("Properties of %,d%n", number);
    for (var p : properties.entrySet()) {
      printProperty(p.getKey(), p.getValue().test(number));
    }
    System.out.println();
  }

  public static void printProperties(long number, long sequence) {
    long endNumber = number + sequence;
    for (long i = number; i < endNumber; i++) {
      printPropertyList(i);
    }
    System.out.println();
  }

  private static void printPropertyList(long number) {
    StringBuilder props = new StringBuilder();
    for (var p : properties.entrySet()) {
      if (p.getValue().test(number)) {
        if (props.length() > 0) {
          props.append(", ");
        }
        props.append(p.getKey());
      }
    }
    System.out.printf("%,14d is %s%n", number, props);
  }

  public static void findProperty(long number, long count, String name) {
    long found = 0;
    Property p = properties.get(name);
    for (long i = 0; found < count; i++) {
      if (p.test(number + i)) {
        found++;
        printPropertyList(number + i);
      }
    }
    System.out.println();
  }

  private static void printProperty(String name, boolean value) {
    System.out.printf("%12s: %b%n", name, value);
  }
}