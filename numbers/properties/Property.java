package numbers.properties;

public abstract class Property {

  boolean shouldList = true;
  String name;
  String[] conflicts;
  String[] conflictsNegated;

  public Property() {
  }

  abstract public boolean test(long number);

  public boolean shouldList() {
    return shouldList;
  }

  public String getName() {
    return name;
  }

  public Property negate() {
    return new Negated(this);
  }

  public String[] getConflicts() {
    return conflicts;
  }
}