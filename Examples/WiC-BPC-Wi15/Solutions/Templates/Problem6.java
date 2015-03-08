import java.util.*;

public class Problem6 {

  //Paramter(s): int[] clockAngles - Angles of clock hands in format [H,M,S]
  //Return:      int[]             - The digital time represented in [H,M,S]
  public static int[] analogIsSoLastEra(int[] clockAngles) {
    
    // YOUR CODE HERE
    return null;
  }


  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//")) {
        String[] timeStrings;
        if (nextLine.contains(" ")) 
          timeStrings = nextLine.split(" ");
        else
          timeStrings = new String[] {nextLine};

        // convert input from string to int
        int[] clockAngles = new int[timeStrings.length];
        for (int i = 0; i < timeStrings.length; ++i) {
          if (!timeStrings[i].equals(""))
            clockAngles[i] = Integer.parseInt(timeStrings[i]);
        }

        // parse the results
        int[] results = analogIsSoLastEra(clockAngles);
        System.out.print(results[0]);
        for (int i = 1; i < results.length; ++i)
          System.out.format(" %d", results[i]);
        System.out.println();
      }
    }
  }

}
