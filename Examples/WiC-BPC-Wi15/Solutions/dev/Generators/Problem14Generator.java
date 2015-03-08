import java.util.Random;
public class Problem14Generator
{
  public static void main(String[] args)
  {
    Random rand = new Random();
    Generator g = new Generator(14);
    for (int i = 0; i < 500; ++i)
    {
      g.writeLine(Integer.toString(rand.nextInt(5000)));
    }
    g.finish();
  }
}
