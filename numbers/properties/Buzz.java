package numbers.properties;

public class Buzz implements Property {

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

  @Override
  public String getName() {
    return "buzz";
  }

  @Override
  public boolean test(long number) {
    return number % 7 == 0 || number % 10 == 7;
  }

}
