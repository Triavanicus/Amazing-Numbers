package numbers.properties;

public class Sunny implements Property {

  Square s = new Square();

  @Override
  public boolean test(long number) {
    return s.test(number + 1);
  }
}
