import java.util.*;

public class Problem10 {

  //Paramter(s): int[] sizes     - The numbers n that are to be placed on the 
  //                               array, reappearing n times.
  //             int[] positions - The positions that the integers in the 
  //                               `sizes` array must be placed in.
  //Return:      int[]           - The new arary with the integers from the
  //                               `sizes` array in the spots indicated by the
  //                               `positions` array.
  public static int[] hushBigDinoBaby(int[] sizes, int[] positions) {
    int max = 0;
    for(int i = 0; i < sizes.length; i++){
      if(sizes[i] + positions[i] > max){
        max = sizes[i] + positions[i];
      }
    }
    if( max == 0 ) {
      return new int[1];
    }
    int[] retVal = new int[max];
    for(int i = 0; i < sizes.length; i++){
      for(int j = 0; j < sizes[i]; j++){
        retVal[positions[i] + j] += sizes[i];
      }
    }
    return retVal;
  }


  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//")) {
        String followingLine = input.nextLine();

        // convert input from string to int
        int[] sizes = toIntArray(nextLine, " ");
        int[] positions = toIntArray(followingLine, " ");

        // parse the results
        int[] results = hushBigDinoBaby(sizes, positions);
        if (results.length > 0) {
          System.out.print(results[0]);
          for (int i = 1; i < results.length; ++i)
            System.out.format(" %d", results[i]);
          System.out.println();
        }
        else
          System.out.println();
      }
    }
  }

  public static int[] toIntArray(String s, String delim)
  {
    String[] split;
    if (s.contains(delim))
      split = s.split(delim);
    else
      split = new String[] {s};

    // convert to int
    int[] returnArr = new int[split.length];
    for (int i = 0; i < split.length; ++i)
      returnArr[i] = Integer.parseInt(split[i]);

    return returnArr;
  }

}
