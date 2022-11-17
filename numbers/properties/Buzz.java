package numbers.properties;

public class Buzz extends Property {

  public Buzz(){
    this.name = "buzz";
    this.conflicts = new String[]{"-buzz"};
    this.conflictsNegated = new String[]{"buzz"};
  }

  @Override
  public boolean test(long number) {
    return number % 7 == 0 || number % 10 == 7;
  }

}
