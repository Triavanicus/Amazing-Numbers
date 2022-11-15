package numbers.properties;

public class Odd implements Property {

  @Override
  public boolean test(long number) {
    return number % 2 == 1;
  }
}
