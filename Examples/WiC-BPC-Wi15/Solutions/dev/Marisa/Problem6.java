
import java.util.*;

public class Problem6 {
 
  //Paramter(s): int[] clockAngles - Angles of clock hands in format [H,M,S]
  //Return:      int[]             - The digital time represented in [H,M,S]
  public static int[] analogIsSoLastEra(int[] clockAngles) {

	int[] arr = new int[3];
	arr[0] = (int)((double)((450 - (clockAngles[0])%360)/360.0)%360 * 12);
	if(arr[0] > 12)
		arr[0] = arr[0] - 12;
		arr[1] = (int)((double)((450 - (clockAngles[1])%360)/360.0)%360 * 60);
	if(arr[1] >= 60)
		arr[1] = arr[1] - 60;
	arr[2] = (int)((double)(450 - (clockAngles[2])%360)/360.0 * 60);
	if(arr[2] >= 60)
		arr[2] = arr[2] - 60;



    return arr;
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
        for (int i = 0; i < timeStrings.length; ++i)
          clockAngles[i] = Integer.parseInt(timeStrings[i]);
 
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
