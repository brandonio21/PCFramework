import java.util.Random;
public class Problem11Generator
{
  public static void main(String[] args)
  {
    Random rand = new Random();
    Generator g = new Generator(11);
    for (int i = 0; i < 200; ++i)
    {
      int length = rand.nextInt(10) + 3;
      int[] verts = new int[length];
      for (int j = 0; j < length; ++j)
      {
        int num = rand.nextInt(10);
        g.write(Integer.toString(num));
        verts[j] = num;
        if (j < length - 1)
          g.write(" ");
      }
      g.writeLine("");

      int edgeCount = rand.nextInt(10);
      for (int j = 0; j < edgeCount; ++j)
      {
        int l = rand.nextInt(length);
        g.write(Integer.toString(verts[l]));
        if (j < edgeCount - 1)
          g.write(" ");
      }
      g.writeLine("");
      for (int j = 0; j < edgeCount; ++j)
      {
        int l = rand.nextInt(length);
        g.write(Integer.toString(verts[l]));
        if (j < edgeCount - 1)
          g.write(" ");
      }
      g.writeLine("");
    }
    g.finish();
  }
}
