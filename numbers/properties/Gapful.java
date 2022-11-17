package numbers.properties;

public class Gapful extends Property {

  public Gapful(){
    this.name = "gapful";
    this.conflicts = new String[]{"-gapful"};
    this.conflictsNegated = new String[]{"gapful"};
  }
  @Override
  public boolean test(long number) {
    if (number < 100) {
      return false;
    }

    String s = String.valueOf(number);
    String firstDigit = s.substring(0, 1);
    String lastDigit = s.substring(s.length() - 1);
    String divisorString = firstDigit.concat(lastDigit);
    long divisor = Long.parseLong(divisorString);

    return number % divisor == 0;
  }
}
