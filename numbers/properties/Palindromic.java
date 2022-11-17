package numbers.properties;

public class Palindromic extends Property {
  public Palindromic() {
    super("palindromic");
  }
  @Override
  public boolean test(long number) {
    String s = Long.toString(number);
    StringBuilder rs = new StringBuilder(s).reverse();
    return s.equals(rs.toString());
  }
}
