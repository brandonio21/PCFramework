import java.util.Random;
public class Problem15Generator
{
  public static void main(String[] args)
  {
    Random rand = new Random();
    Generator g = new Generator(15);
    for (int i = 0; i < 500; ++i)
    {
      int count = rand.nextInt(10) + 1;
      for (int j = 0; j < count; ++j)
      {
        g.write(Integer.toString(rand.nextInt(10)));
        if (j < count - 1)
          g.write(" ");
      }
      g.writeLine("");
    }
    g.finish();
  }
}
