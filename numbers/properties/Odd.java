package numbers.properties;

public class Odd extends Property {
  public Odd() {
    super("odd", new String[]{"even"}, new String[]{"-even"});
  }

  @Override
  public boolean test(long number) {
    return number % 2 == 1;
  }
}
