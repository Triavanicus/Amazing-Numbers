package numbers.properties;

public class Duck extends Property {

  public Duck(){
    super("duck", new String[]{"spy"});
  }
  @Override
  public boolean test(long number) {
    return Long.toString(number).contains("0");
  }
}
