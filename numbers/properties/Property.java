package numbers.properties;

public abstract class Property {

  boolean shouldList = true;
  String name;
  String[] conflicts;
  String[] conflictsNegated;

  public Property() {
  }

  public Property(String name) {
    this.name = name;
    this.conflicts = new String[]{"-" + name};
    this.conflictsNegated = new String[]{name};
  }

  public Property(String name, String[] additionalConflicts) {
    this(name);
    if (additionalConflicts != null) {
      String[] newConflicts = new String[additionalConflicts.length + this.conflicts.length];
      System.arraycopy(this.conflicts, 0, newConflicts, 0, this.conflicts.length);
      System.arraycopy(additionalConflicts, 0, newConflicts, this.conflicts.length,
          additionalConflicts.length);
      this.conflicts = newConflicts;
    }
  }

  public Property(String name, String[] additionalConflicts, String[] additionalConflictsNegated) {
    this(name, additionalConflicts);
    if (additionalConflictsNegated != null) {
      String[] newConflicts = new String[additionalConflictsNegated.length
          + this.conflictsNegated.length];
      System.arraycopy(this.conflictsNegated, 0, newConflicts, 0, this.conflictsNegated.length);
      System.arraycopy(additionalConflictsNegated, 0, newConflicts, this.conflictsNegated.length,
          additionalConflicts.length);
      this.conflictsNegated = newConflicts;
    }
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