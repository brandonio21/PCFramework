import java.util.*;

public class Problem3 {

  //Paramter(s): String[] colors - The list of colors of Peter's crayons.
  //Return:      int             - The number of uniquely colored crayons.
  public static int detectBraggingRights(String[] colors) {
    HashSet<String> colorSet = new HashSet<String>();
    for (int i = 0; i < colors.length; ++i) {
      if (!colors[i].equals("") && colors[i] != null)
        colorSet.add(colors[i].toLowerCase());
    }
    
    return colorSet.size();
  }


  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//")) {
        if (nextLine.contains(" ")) {
          String[] colorStrings = nextLine.split(" ");
          System.out.println(detectBraggingRights(colorStrings));
        }
        else if (!nextLine.equals(""))
          System.out.println(detectBraggingRights(new String[] {nextLine}));
        else 
          System.out.println(detectBraggingRights(new String[] {}));
      }
    }
  }

}
