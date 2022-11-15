package numbers.properties;

public class Jumping implements Property {

  @Override
  public boolean test(long number) {
    long lastDigit = 0;
    boolean first = true;
    while (number != 0) {
      long digit = number % 10;
      if (first) {
        lastDigit = digit + 1;
        first = false;
      }
      number /= 10;
      if (Math.abs(lastDigit - digit) != 1) {
        return false;
      }
      lastDigit = digit;
    }
    return true;
  }
}
