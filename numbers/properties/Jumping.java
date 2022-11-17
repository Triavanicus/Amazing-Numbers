package numbers.properties;

public class Jumping extends Property {

  public Jumping() {
    super("jumping");
  }

  @Override
  public boolean test(long number) {
    int[] digits = Helper.getDigits(number);

    if (digits.length == 1) {
      return true;
    }

    for (int i = 0; i < digits.length - 1; i++) {
      if (Math.abs(digits[i] - digits[i + 1]) != 1) {
        return false;
      }
    }
    return true;
  }
}
