package numbers;

public class NumberInfo {

  public static boolean isNatural(long number) {
    return number > 0;
  }

  public static boolean isEven(long number) {
    return number % 2 == 0;
  }

  public static boolean isOdd(long number) {
    return number % 2 == 1;
  }

  public static boolean isBuzz(long number) {
    return number % 7 == 0 || number % 10 == 7;
  }

  public static boolean isDuck(long number) {
    return Long.toString(number).contains("0");
  }

  public static boolean isPalindrome(long number) {
    String s = Long.toString(number);
    String rs = "";
    for(int i = s.length() -1; i >= 0; i--){
      rs = rs.concat(String.valueOf(s.charAt(i)));
    }
    return s.equals(rs);
  }

  public static int getBuzzNumberType(long number) {
    int result = 0;

    if (number % 7 == 0) {
      result += 1;
    }
    if (number % 10 == 7) {
      result += 2;
    }
    return result;
  }

  public static void printBuzzInfo(long number) {
    int buzzType = getBuzzNumberType(number);
    if (buzzType > 0) {
      System.out.println("It is a Buzz number.");
      System.out.println("Explanation:");
      switch (buzzType) {
        case 1 -> System.out.println(number + " is divisible by 7.");
        case 2 -> System.out.println(number + " ends with 7.");
        case 3 -> System.out.println(number + " is divisible by 7 and ends with 7.");
      }
    } else {
      System.out.println("It is not a Buzz number.");
      System.out.println("Explanation:");
      System.out.println(number + " is neither divisible by 7 nor does it end with 7.");
    }
  }

  public static void printProperties(long number) {
    System.out.printf("Properties of %,d%n", number);
    printProperty("even", isEven(number));
    printProperty("odd", isOdd(number));
    printProperty("buzz", isBuzz(number));
    printProperty("duck", isDuck(number));
    printProperty("palindromic", isPalindrome(number));
  }

  private static void printProperty(String name, boolean value) {
    System.out.printf("%12s: %b%n", name, value);
  }
}