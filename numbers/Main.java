package numbers;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter a natural number:");
    String answer = sc.nextLine();

    int number = Integer.parseInt(answer);

    if (!NumberInfo.isNatural(number)) {
      System.out.println("This number is not natural!");
      return;
    }

    NumberInfo.printProperties(number);
  }
}
