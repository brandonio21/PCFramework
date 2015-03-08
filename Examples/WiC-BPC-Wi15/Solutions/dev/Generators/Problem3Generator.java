import java.util.Random;
public class Problem3Generator
{
  public static void main(String[] args)
  {
    Random rand = new Random();
    Generator g = new Generator(3);
    for (int i = 0; i < 500; ++i)
    {
      for (int j = 0; j < 100; ++j)
      {
        if (rand.nextInt(100) <= 25)
        {
          for (int k = 0; k < 20; ++k)
          {
            if (rand.nextInt(100) <= 50)
            {
              g.write(String.valueOf((char)(rand.nextInt(26) + 'a')));
            }
          }
          if (j < 99)
            g.write(" ");
          
        }
      }
      g.writeLine("");
    }
    g.finish();
  }
}
