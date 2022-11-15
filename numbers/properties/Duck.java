package numbers.properties;

public class Duck implements Property {

  @Override
  public String getName() {
    return "duck";
  }

  @Override
  public boolean test(long number) {
    return Long.toString(number).contains("0");
  }
}
