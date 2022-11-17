package numbers.properties;

public class Sad extends Property {

  public Sad() {
    this.name = "sad";
    this.conflicts = new String[]{"-sad", "happy"};
    this.conflictsNegated = new String[]{"sad", "-happy"};
  }

  final Happy happy = new Happy();

  @Override
  public boolean test(long number) {
    return !happy.test(number);
  }
}
