
import java.util.*;

public class Problem5 {
 
  //Paramter(s): int[] coconutVolumes - The volumes of available coconuts
  //             int   max            - The maximum number of coconuts that
  //                                    Gary can hold.
  //Return:      int                  - The volume of coconut water he can drink
  public static int poweredByCoconuts(int[] coconutVolumes, int max) {
     int count = 0;
     Arrays.sort(coconutVolumes);
     if(coconutVolumes.length <= max){
    	 for(int i = 0; i < coconutVolumes.length; i++){
    		 count = count + coconutVolumes[i];
    	 }
    	 return count;
     }
     for(int i = coconutVolumes.length - 1; i >= coconutVolumes.length - max; i-- ){
    	 count = coconutVolumes[i] + count;
     }
    // YOUR CODE HERE
    return count;
  }
 
 
  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//")) {
        String followingLine = input.nextLine();
        String[] volumes;
        if (nextLine.contains(" "))
          volumes = nextLine.split(" ");
        else
          volumes = new String[] {nextLine};
 
        //convert volumes to int
        int[] volumeInts = new int[volumes.length];
        for (int i = 0; i < volumes.length; ++i)
          volumeInts[i] = Integer.parseInt(volumes[i]);
 
        System.out.println(poweredByCoconuts(volumeInts,
              Integer.parseInt(followingLine)));
      }
    }
  }
 
}
