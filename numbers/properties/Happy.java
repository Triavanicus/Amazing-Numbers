package numbers.properties;

import java.util.HashSet;

public class Happy implements Property {

  @Override
  public boolean test(long number) {
    long lastSequence = number;
    HashSet<Long> sequences = new HashSet<>();
    while (true) {
      lastSequence = (happySequence(lastSequence));
      if (lastSequence == 1) {
        return true;
      }
      if (sequences.contains(lastSequence)) {
        return false;
      } else {
        sequences.add(lastSequence);
      }
    }
  }

  private long happySequence(long number) {
    int[] digits = Helper.getDigits(number);
    long sum = 0;
    for (int digit : digits) {
      sum += (long) digit * digit;
    }
    return sum;
  }
}
