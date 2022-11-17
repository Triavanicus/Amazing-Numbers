package numbers.properties;

public class Sunny extends Property {

  public Sunny() {
    this.name = "sunny";
    this.conflicts = new String[]{"-sunny", "square"};
    this.conflictsNegated = new String[]{"sunny"};
  }

  final Square s = new Square();

  @Override
  public boolean test(long number) {
    return s.test(number + 1);
  }
}
