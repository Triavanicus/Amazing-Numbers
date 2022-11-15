package numbers.properties;

public class Even implements Property {

  @Override
  public String getName() {
    return "even";
  }

  @Override
  public boolean test(long number) {
    return number % 2 == 0;
  }
}
