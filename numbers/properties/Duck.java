package numbers.properties;

public class Duck extends Property {

  public Duck(){
    this.name = "duck";
    this.conflicts = new String[]{"-duck", "spy"};
    this.conflictsNegated = new String[]{"duck"};
  }
  @Override
  public boolean test(long number) {
    return Long.toString(number).contains("0");
  }
}
