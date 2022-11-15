package numbers;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter a natural number:");
    String answer = sc.nextLine();

    int number = Integer.parseInt(answer);

    if (!isNatural(number)) {
      System.out.println("This number is not natural!");
      return;
    }

    if (isEven(number)) {
      System.out.println("This number is Even.");
    } else {
      System.out.println("This number is Odd.");
    }

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

  public static boolean isNatural(int number) {
    return number > 0;
  }

  public static boolean isEven(int number) {
    return number % 2 == 0;
  }

  public static int getBuzzNumberType(int number) {
    int result = 0;

    if (number % 7 == 0) {
      result += 1;
    }
    if (number % 10 == 7) {
      result += 2;
    }
    return result;
  }
}
