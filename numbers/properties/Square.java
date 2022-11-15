package numbers.properties;

public class Square implements Property {

  @Override
  public boolean test(long number) {
    long sqrt = (long) Math.sqrt(number);
    return sqrt * sqrt == number;
  }
}
