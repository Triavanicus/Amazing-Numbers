package numbers.properties;

public class Sad extends Property {

  public Sad() {
    super("sad", new String[]{"happy"}, new String[]{"-happy"});
  }

  final Happy happy = new Happy();

  @Override
  public boolean test(long number) {
    return !happy.test(number);
  }
}
