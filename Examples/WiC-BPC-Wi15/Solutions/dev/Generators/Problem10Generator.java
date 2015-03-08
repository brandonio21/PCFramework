import java.util.Random;
public class Problem10Generator
{
  public static void main(String[] args)
  {
    Random rand = new Random();
    Generator g = new Generator(10);
    for (int i = 0; i < 500; ++i)
    {
      int length = rand.nextInt(1000);
      for (int j = 0; j < length; ++j)
      {
        g.write(Integer.toString(rand.nextInt(1000)));
        if (j < length - 1)
          g.write(" ");
      }
      g.writeLine(" ");
      for (int j = 0; j < length; ++j)
      {
        g.write(Integer.toString(rand.nextInt(1000)));
        if (j < length - 1)
          g.write(" ");
      }
      g.writeLine(" ");
    }
    g.finish();
  }
}
