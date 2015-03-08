import java.util.Random;
public class Problem8Generator
{
  public static void main(String[] args)
  {
    Random rand = new Random();
    Generator g = new Generator(8);
    for (int i = 0; i < 500; ++i)
    {
      for (int j = 0; j < 1000; ++j)
      {
        if (rand.nextInt(100) <= 33)
        {
          g.write(Integer.toString(rand.nextInt(1000)));
        if (j < 999)
          g.write(" ");
        }
      }
      g.writeLine("");
    }
    g.finish();
  }
}
