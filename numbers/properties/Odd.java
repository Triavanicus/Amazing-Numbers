package numbers.properties;

public class Odd implements Property {

  @Override
  public String getName() {
    return "odd";
  }

  @Override
  public boolean test(long number) {
    return number % 2 == 1;
  }
}
