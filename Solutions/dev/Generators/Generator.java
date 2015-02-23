import java.io.*;

public class Generator
{
  private int problemNumber;
  private final String GENERATOR_PATH = "../tests/problem%d_generated.in";
  private BufferedWriter writer;

  public Generator(int num)
  {
    this.problemNumber = num;
    try
    {
      writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
              String.format(GENERATOR_PATH, num), false)));
    }
    catch (IOException ex)
    {
      
    }
  }

  public void writeLine(String contents)
  {
    try {
    writer.write(contents);
    writer.newLine();
    }
    catch (IOException ex) {}

  }

  public void write(String contents)
  {
    try {
    writer.write(contents);
    }
    catch (IOException e) {}
  }

  public void finish()
  {
    try {
    writer.close();
    }
    catch (IOException e) {}
  }
}
