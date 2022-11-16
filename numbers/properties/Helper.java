package numbers.properties;

class Helper {

  static int[] getDigits(long number) {
    int numberOfDigits = countDigits(number);
    int[] digits = new int[numberOfDigits];
    for (int i = 0; i < numberOfDigits; i++) {
      digits[i] = getDigit(number, i);
    }
    return digits;
  }

  static int getDigit(long number, int digit) {
    return (int) ((number / (long) Math.pow(10, digit)) % 10);
  }

  static int countDigits(long number) {
    return (int) Math.floor(Math.log10(number) + 1);
  }
}
