import java.util.*;

public class Problem6 {

  //Paramter(s): int[] clockAngles - Angles of clock hands in format [H,M,S]
  //Return:      int[]             - The digital time represented in [H,M,S]
  public static int[] analogIsSoLastEra(int[] clockAngles) {
    while (clockAngles[0] > 360)
      clockAngles[0] -= 360;
    while (clockAngles[1] > 360)
      clockAngles[1] -= 360;
    while (clockAngles[2] > 360)
      clockAngles[2] -= 360;

    int hour = 3 - (int)(Math.ceil(clockAngles[0] / 30.0));
    hour = (hour < 0) ? hour + 12 : (hour == 0) ? 12 : hour;
    int minute = 15 - (int)(Math.ceil((clockAngles[1] / 6.0)));
    minute = (minute < 0) ? minute + 60 : minute;
    int seconds = 15 - (clockAngles[2] /= 6);
    seconds = (seconds < 0) ? seconds + 60 : seconds;

    return new int[] {hour, minute, seconds};
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
