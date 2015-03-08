import java.util.*;

public class Problem11 {

  //Paramter(s): int[] vertices  - The vertices of the graph
  //             int[] predators - The beginning of edges (where it comes from)
  //             int[] prey      - The end of edges (where they point)
  //Return:      boolean         - Whether the graph contains cycles
  public static boolean hasCircleOfDeath(int[] vertices, int[] predators,
      int[] prey) {
    
    // YOUR CODE HERE
    return false;
  }


  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//")) {
        String followingLine = input.nextLine();
        String followingFollowingLine = input.nextLine();

        // convert input from string to int
        int[] vertices = toIntArray(nextLine, " ");
        int[] predators = toIntArray(followingLine, " ");
        int[] prey = toIntArray(followingFollowingLine, " ");

        // parse the results
        System.out.println(Boolean.toString(hasCircleOfDeath(vertices,
                predators, prey)));
      }
    }
  }

  public static int[] toIntArray(String s, String delim)
  {
    if (s.equals(""))
      return new int[0];

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
