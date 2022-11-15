package numbers.properties;

public class Palindrome implements Property {

  @Override
  public String getName() {
    return "palindromic";
  }

  @Override
  public boolean test(long number) {
    String s = Long.toString(number);
    String rs = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      rs = rs.concat(String.valueOf(s.charAt(i)));
    }
    return s.equals(rs);
  }
}
