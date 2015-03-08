
import java.util.*;

public class Problem11 {
 
  //Paramter(s): int[] vertices  - The vertices of the graph
  //             int[] predators - The beginning of edges (where it comes from)
  //             int[] prey      - The end of edges (where they point)
  //Return:      boolean         - Whether the graph contains cycles
  public static boolean hasCircleOfDeath(int[] vertices, int[] predators, int[] prey){
	  Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
	  Map<Integer, Integer> explored = new HashMap<Integer, Integer>();

	  for (int i = 0; i < vertices.length; i++){
		  visited.put(vertices[i], 0);
		  explored.put(vertices[i], 0);
	  }
	  for (int i = 0; i < vertices.length; i++){
		  if(explore(vertices[i], predators, prey, visited, explored) == true)
			  return true;
		  explored.put(vertices[i], 1);
	  }
	  return false;
  }
 public static boolean explore(int vertice, int[] pred, int[] prey, Map<Integer, 
		 					   Integer> visited, Map<Integer, Integer> explored){
	 visited.put(vertice, 1);
	 for (int i = 0; i < pred.length; i++){
		 if(pred[i] == vertice && explored.get(prey[i]) != 1 ){
			 if(visited.get(prey[i]) == 1){
				 return true;
			 }
			 if( explore(prey[i], pred, prey, visited, explored) == true)
				 return true;
		 }
	 }
	 visited.put(vertice, 0);
	 explored.put(vertice, 1);
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
