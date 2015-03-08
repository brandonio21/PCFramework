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
    int[] buildArray = new int[1];
    int length = 1;
    buildArray[0] = 0;
    
    

    for (int i = 0; i < sizes.length; i++)
    {
      int numberToPut = sizes[i];
      int position = positions[i];
      
      while (length < (position + 1)) {
        buildArray = addAnotherSlot(buildArray);
        length++;
      }

      for (int reps = 0; reps < numberToPut; reps++)
      {
        while (length < (position + reps + 1)) {
          buildArray = addAnotherSlot(buildArray);
          length++;
        }

        buildArray[position + reps] += numberToPut;
      }

    }

    return buildArray;
  }

  public static int[] addAnotherSlot(int[] array)
  {
    int[] newArray = new int[array.length + 1];
    for (int i = 0; i < array.length; i++)
      newArray[i] = array[i];
    newArray[array.length] = 0;

    return newArray;
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
        System.out.print(results[0]);
        for (int i = 1; i < results.length; ++i)
          System.out.format(" %d", results[i]);
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
