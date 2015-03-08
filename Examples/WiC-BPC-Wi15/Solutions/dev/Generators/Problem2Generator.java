import java.util.Random;
public class Problem2Generator
{
  public static void main(String[] args)
  {
    Random rand = new Random();
    Generator g = new Generator(2);
    for (int i = 0; i < 500; ++i)
    {
      g.writeLine(Integer.toString(rand.nextInt(20000)));
    }
    g.finish();
  }
}
