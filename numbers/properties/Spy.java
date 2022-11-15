package numbers.properties;

public class Spy implements Property {

  @Override
  public boolean test(long number) {
    long sum = 0;
    long product = 1;
    while (number != 0) {
      long digit = number % 10;
      number /= 10;
      sum += digit;
      product *= digit;
    }
    return sum == product;
  }
}
