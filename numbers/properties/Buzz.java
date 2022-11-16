package numbers.properties;

public class Buzz implements Property {

  @Override
  public boolean test(long number) {
    return number % 7 == 0 || number % 10 == 7;
  }

}
