import java.util.*;

public class Problem3 {

  //Paramter(s): String[] colors - The list of colors of Peter's crayons.
  //Return:      int             - The number of uniquely colored crayons.
  public static int detectBraggingRights(String[] colors) {
    if(colors.length <= 1){
    	return colors.length;
    }
    for(int i = 0; i < colors.length; i++){
      colors[i] = colors[i].toLowerCase();
    }
	  Arrays.sort(colors);;
    int num = 1;
    String curr = colors[0];
    for(int i = 1; i < colors.length; i++){
    	if(!curr.equals(colors[i])){
    		num++;
    		curr = colors[i];
    	}
    }
	
    return num;
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
