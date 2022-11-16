package numbers;

import java.util.HashSet;
import java.util.Map;
import numbers.properties.Buzz;
import numbers.properties.Duck;
import numbers.properties.Even;
import numbers.properties.Gapful;
import numbers.properties.Happy;
import numbers.properties.Jumping;
import numbers.properties.Negated;
import numbers.properties.Odd;
import numbers.properties.Palindrome;
import numbers.properties.Property;
import numbers.properties.Sad;
import numbers.properties.Spy;
import numbers.properties.Square;
import numbers.properties.Sunny;

public class NumberInfo {

  public static final Map<String, Property> properties;
  public static final Map<String, String[]> conflictingProperties;

  static {
    properties = Map.ofEntries(
        Map.entry("even", new Even()),
        Map.entry("-even", new Negated(new Even())),
        Map.entry("odd", new Odd()),
        Map.entry("-odd", new Negated(new Odd())),
        Map.entry("buzz", new Buzz()),
        Map.entry("-buzz", new Negated(new Buzz())),
        Map.entry("duck", new Duck()),
        Map.entry("-duck", new Negated(new Duck())),
        Map.entry("palindromic", new Palindrome()),
        Map.entry("-palindromic", new Negated(new Palindrome())),
        Map.entry("gapful", new Gapful()),
        Map.entry("-gapful", new Negated(new Gapful())),
        Map.entry("spy", new Spy()),
        Map.entry("-spy", new Negated(new Spy())),
        Map.entry("square", new Square()),
        Map.entry("-square", new Negated(new Square())),
        Map.entry("sunny", new Sunny()),
        Map.entry("-sunny", new Negated(new Sunny())),
        Map.entry("jumping", new Jumping()),
        Map.entry("-jumping", new Negated(new Jumping())),
        Map.entry("happy", new Happy()),
        Map.entry("-happy", new Negated(new Happy())),
        Map.entry("sad", new Sad()),
        Map.entry("-sad", new Negated(new Sad()))
    );
    conflictingProperties = Map.ofEntries(
        Map.entry("even", new String[]{"-even", "odd"}),
        Map.entry("-even", new String[]{"even", "-odd"}),
        Map.entry("odd", new String[]{"-odd", "even"}),
        Map.entry("-odd", new String[]{"odd", "-even"}),
        Map.entry("buzz", new String[]{"-buzz"}),
        Map.entry("-buzz", new String[]{"buzz"}),
        Map.entry("duck", new String[]{"-duck", "spy"}),
        Map.entry("-duck", new String[]{"duck"}),
        Map.entry("palindromic", new String[]{"-palindromic"}),
        Map.entry("-palindromic", new String[]{"palindromic"}),
        Map.entry("gapful", new String[]{"-gapful"}),
        Map.entry("-gapful", new String[]{"gapful"}),
        Map.entry("spy", new String[]{"-spy", "duck"}),
        Map.entry("-spy", new String[]{"spy"}),
        Map.entry("square", new String[]{"-square", "sunny"}),
        Map.entry("-square", new String[]{"square"}),
        Map.entry("sunny", new String[]{"-sunny", "square"}),
        Map.entry("-sunny", new String[]{"sunny"}),
        Map.entry("jumping", new String[]{"-jumping"}),
        Map.entry("-jumping", new String[]{"jumping"}),
        Map.entry("happy", new String[]{"-happy", "sad"}),
        Map.entry("-happy", new String[]{"happy", "-sad"}),
        Map.entry("sad", new String[]{"-sad", "happy"}),
        Map.entry("-sad", new String[]{"sad", "-happy"})
    );
  }

  public static boolean isUnnatural(long number) {
    return number < 1;
  }

  public static void printProperties(long number) {
    System.out.printf("Properties of %,d%n", number);
    for (var p : properties.entrySet()) {
      if (p.getKey().startsWith("-")) {
        continue;
      }
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
      if (p.getKey().startsWith("-")) {
        continue;
      }

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