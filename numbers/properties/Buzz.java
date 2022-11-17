package numbers.properties;

public class Buzz extends Property {

  public Buzz(){
    super("buzz");
  }

  @Override
  public boolean test(long number) {
    return number % 7 == 0 || number % 10 == 7;
  }

}
