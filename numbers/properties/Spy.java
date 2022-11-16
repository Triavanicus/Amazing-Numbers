package numbers.properties;

public class Spy implements Property {

  @Override
  public boolean test(long number) {
    long sum = 0;
    long product = 1;

    int[] digits = Helper.getDigits(number);
    for (int digit : digits) {
      sum += digit;
      product *= digit;
    }
    return sum == product;
  }
}
