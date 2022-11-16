package numbers.properties;

public class Sad implements Property {

  final Happy happy = new Happy();

  @Override
  public boolean test(long number) {
    return !happy.test(number);
  }
}
