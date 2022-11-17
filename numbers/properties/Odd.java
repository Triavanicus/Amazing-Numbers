package numbers.properties;

public class Odd extends Property {
  public Odd() {
    this.name = "odd";
    this.conflicts = new String[]{"-odd", "even"};
    this.conflictsNegated = new String[]{"odd", "-even"};
  }

  @Override
  public boolean test(long number) {
    return number % 2 == 1;
  }
}
