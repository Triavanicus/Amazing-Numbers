package numbers.properties;

public class Negated implements Property {

  private final Property property;

  public Negated(Property property) {
    this.property = property;
  }

  @Override
  public boolean test(long number) {
    return !property.test(number);
  }
}
