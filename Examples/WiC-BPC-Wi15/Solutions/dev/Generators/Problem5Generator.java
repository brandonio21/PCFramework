import java.util.Random;
public class Problem5Generator
{
  public static void main(String[] args)
  {
    Random rand = new Random();
    Generator g = new Generator(5);
    for (int i = 0; i < 500; ++i)
    {
      g.writeLine(Integer.toString(rand.nextInt(10000)));
      g.writeLine(Integer.toString(rand.nextInt(10000)));
    }
    g.finish();
  }
}
