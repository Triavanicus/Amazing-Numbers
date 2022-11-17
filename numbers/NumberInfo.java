package numbers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import numbers.properties.Buzz;
import numbers.properties.Duck;
import numbers.properties.Even;
import numbers.properties.Gapful;
import numbers.properties.Happy;
import numbers.properties.Jumping;
import numbers.properties.Odd;
import numbers.properties.Palindromic;
import numbers.properties.Property;
import numbers.properties.Sad;
import numbers.properties.Spy;
import numbers.properties.Square;
import numbers.properties.Sunny;

public class NumberInfo {

  private static final Map<String, Property> properties = new HashMap<>();
  private static final Map<String, String[]> conflictingProperties = new HashMap<>();

  static {
    for (Property p : new Property[]{
        new Buzz(),
        new Duck(),
        new Even(),
        new Gapful(),
        new Happy(),
        new Jumping(),
        new Odd(),
        new Palindromic(),
        new Sad(),
        new Spy(),
        new Square(),
        new Sunny(),
    }) {
      properties.put(p.getName(), p);
      conflictingProperties.put(p.getName(), p.getConflicts());
      p = p.negate();
      properties.put(p.getName(), p);
      conflictingProperties.put(p.getName(), p.getConflicts());
    }
  }

  public static boolean isUnnatural(long number) {
    return number < 1;
  }

  public static void printProperties(long number) {
    System.out.printf("Properties of %,d%n", number);
    for (var p : properties.values()) {
      if (p.shouldList()) {
        printProperty(p.getName(), p.test(number));
      }
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

  public static Map<String, Property> getProperties() {
    return properties;
  }

  private static void printPropertyList(long number) {
    StringBuilder props = new StringBuilder();
    for (var p : properties.values()) {
      if (p.shouldList() && p.test(number)) {
        if (props.length() > 0) {
          props.append(", ");
        }
        props.append(p.getName());
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

  public static void findProperties(long number, long count, String[] searchNames) {
    long found = 0;
    Property[] searchProps = new Property[searchNames.length];
    for (int i = 0; i < searchProps.length; i++) {
      searchProps[i] = properties.get(searchNames[i].toLowerCase());
    }

    for (long i = 0; found < count; i++) {
      boolean hasAllProperties = true;
      for (Property p : searchProps) {
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