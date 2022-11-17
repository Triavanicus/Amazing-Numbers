package numbers.properties;

public class Square extends Property {

  public Square() {
    super("square", new String[]{"sunny"});
  }

  @Override
  public boolean test(long number) {
    long sqrt = (long) Math.sqrt(number);
    return sqrt * sqrt == number;
  }
}
