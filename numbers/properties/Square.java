package numbers.properties;

public class Square extends Property {

  public Square() {
    this.name = "square";
    this.conflicts = new String[]{"-square", "sunny"};
    this.conflictsNegated = new String[]{"square"};
  }

  @Override
  public boolean test(long number) {
    long sqrt = (long) Math.sqrt(number);
    return sqrt * sqrt == number;
  }
}
