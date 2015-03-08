import java.util.*;

public class Problem7 {

  //Paramter(s): String text - The text to "read"
  //Return:      String      - The text with words individually reversed
  public static String ssoBAekiLgnidaer(String text) {
    StringTokenizer st = new StringTokenizer(text);
    String retVal = "";
    while(st.hasMoreTokens()){
      retVal += new StringBuffer(st.nextToken()).reverse().toString();
      if(st.hasMoreTokens()){
        retVal += " ";
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
      if (!nextLine.startsWith("//"))
        System.out.println(ssoBAekiLgnidaer((nextLine)));
    }

  }
}


