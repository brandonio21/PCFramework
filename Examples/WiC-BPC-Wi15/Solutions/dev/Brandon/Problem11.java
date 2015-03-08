import java.util.*;

public class Problem11 {

  //Paramter(s): int[] vertices  - The vertices of the graph
  //             int[] predators - The beginning of edges (where it comes from)
  //             int[] prey      - The end of edges (where they point)
  //Return:      boolean         - Whether the graph contains cycles
  public static boolean hasCircleOfDeath(int[] vertices, int[] predators,
      int[] prey) {

    if (vertices.length == 0)
      return false;

    boolean[] discovered = new boolean[vertices.length];
    // First, check for any loops
    for (int i = 0; i < predators.length; ++i)
    {
      if (predators[i] == prey[i])
        return true;
    }

    // Now check for basic cycles
    for (int i = 0; i < predators.length; ++i)
    {
      for (int k = 0; k < predators.length; ++k)
      {
        if (k != i && predators[k] == prey[i] && prey[k] == predators[i])
          return true;
      }
    }

    // We are going to run DFS to find cycles
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(0);
    while (!stack.empty())
    {
      int v = stack.pop();
      if (!discovered[v])
      {
        discovered[v] = true;
        for (int i = 0; i < predators.length; ++i)
        {
          if (predators[i] == vertices[v])
          {
            for (int j = 0; j < vertices.length; j++)
            {
              if (vertices[j] == prey[i])
              {
                if (discovered[j])
                  return true;

                stack.push(j);
                break;
              }
            }
          }
        }
      }
    }
    
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
