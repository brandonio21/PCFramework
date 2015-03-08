import java.util.Random;
public class Problem6Generator
{
  public static void main(String[] args)
  {
    Random rand = new Random();
    Generator g = new Generator(6);
    for (int i = 0; i < 500; ++i)
    {
      for (int j = 0; j < 3; ++j)
      {
        g.write(Integer.toString(rand.nextInt(360)));
        if (j < 2)
          g.write(" ");
      }
      g.writeLine("");
    }
    g.finish();
  }
}
