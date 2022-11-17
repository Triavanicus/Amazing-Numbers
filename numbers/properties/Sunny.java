package numbers.properties;

public class Sunny extends Property {

  public Sunny() {
    super("sunny", new String[]{"square"});
  }

  final Square s = new Square();

  @Override
  public boolean test(long number) {
    return s.test(number + 1);
  }
}
