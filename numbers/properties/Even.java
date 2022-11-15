package numbers.properties;

public class Even implements Property {

  @Override
  public boolean test(long number) {
    return number % 2 == 0;
  }
}
