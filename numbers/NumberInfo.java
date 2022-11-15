package numbers;

import java.util.HashSet;
import java.util.Map;
import numbers.properties.Buzz;
import numbers.properties.Duck;
import numbers.properties.Even;
import numbers.properties.Gapful;
import numbers.properties.Jumping;
import numbers.properties.Odd;
import numbers.properties.Palindrome;
import numbers.properties.Property;
import numbers.properties.Spy;
import numbers.properties.Square;
import numbers.properties.Sunny;

public class NumberInfo {

  public static final Map<String, Property> properties;
  public static final Map<String, String[]> conflictingProperties;

  static {
    properties = Map.of(
        "even", new Even(),
        "odd", new Odd(),
        "buzz", new Buzz(),
        "duck", new Duck(),
        "palindromic", new Palindrome(),
        "gapful", new Gapful(),
        "spy", new Spy(),
        "square", new Square(),
        "sunny", new Sunny(),
        "jumping", new Jumping()
    );

    conflictingProperties = Map.of(
        "even", new String[]{"odd"},
        "odd", new String[]{"even"},
        "spy", new String[]{"duck"},
        "duck", new String[]{"spy"},
        "square", new String[]{"sunny"},
        "sunny", new String[]{"square"}
    );
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
    Property p = properties.get(name.toLowerCase());
    for (long i = 0; found < count; i++) {
      if (p.test(number + i)) {
        found++;
        printPropertyList(number + i);
      }
    }
    System.out.println();
  }

  public static String[] getConflictingProperties(String[] args) {
    HashSet<String> conflicts = new HashSet<>();
    for (int i = 0; i < args.length - 1; i++) {
      if (!conflictingProperties.containsKey(args[i])) {
        continue;
      }
      var props = conflictingProperties.get(args[i]);
      for (int j = i + 1; j < args.length; j++) {
        for (String prop : props) {
          if (args[j].equals(prop)) {
            conflicts.add(args[i]);
            conflicts.add(args[j]);
          }
        }
      }
    }
    return conflicts.toArray(new String[]{});
  }

  private static void printProperty(String name, boolean value) {
    System.out.printf("%12s: %b%n", name, value);
  }

  public static void findProperties(long number, long count, String[] propertyNames) {
    long found = 0;
    Property[] props = new Property[propertyNames.length];
    for (int i = 0; i < props.length; i++) {
      props[i] = properties.get(propertyNames[i].toLowerCase());
    }
    for (long i = 0; found < count; i++) {
      boolean hasAllProperties = true;
      for (Property p : props) {
        if (!p.test(number + i)) {
          hasAllProperties = false;
          break;
        }
      }
      if (hasAllProperties) {
        found++;
        printPropertyList(number + i);
      }
    }
    System.out.println();

  }
}