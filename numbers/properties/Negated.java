package numbers.properties;

public class Negated extends Property {

  private final Property property;

  public Negated(Property property) {
    this.property = property;
    this.name = "-" + property.name;
    this.shouldList = false;
  }

  @Override
  public boolean test(long number) {
    return !property.test(number);
  }

  @Override
  public String[] getConflicts() {
    return property.conflictsNegated;
  }
}
