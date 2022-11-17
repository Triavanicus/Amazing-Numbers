package numbers.properties;

public class Even extends Property {

  public Even(){
    this.name = "even";
    this.conflicts = new String[]{"-even", "odd"};
    this.conflictsNegated = new String[]{"even", "-odd"};
  }
  @Override
  public boolean test(long number) {
    return number % 2 == 0;
  }
}
