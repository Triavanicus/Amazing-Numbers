package numbers.properties;

public class Even extends Property {

  public Even(){
    super("even", new String[]{"odd"}, new String[]{"-odd"});
  }
  @Override
  public boolean test(long number) {
    return number % 2 == 0;
  }
}
