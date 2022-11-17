package numbers.properties;

public class Spy extends Property {


  public Spy() {
    this.name = "spy";
    this.conflicts = new String[]{"-spy", "duck"};
    this.conflictsNegated = new String[]{"spy"};
  }

  @Override
  public boolean test(long number) {
    long sum = 0;
    long product = 1;

    int[] digits = Helper.getDigits(number);
    for (int digit : digits) {
      sum += digit;
      product *= digit;
    }
    return sum == product;
  }
}
