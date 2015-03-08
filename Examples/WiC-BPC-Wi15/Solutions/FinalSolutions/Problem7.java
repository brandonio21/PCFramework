import java.util.*;

public class Problem7 {

  //Paramter(s): String text - The text to "read"
  //Return:      String      - The text with words individually reversed
  public static String ssoBAekiLgnidaer(String text) {

    StringBuilder sb = new StringBuilder();
    String[] words = text.split(" ");
    for (int i = 0; i < words.length; ++i)
      sb.append(" ").append(reverseWord(words[i]));

    
    return sb.substring(1);
  }

  public static String reverseWord(String word)
  {
    char[] forwardWord = word.toCharArray();
    char[] reverseWord = new char[forwardWord.length];

    for (int i = 0; i < forwardWord.length; ++i)
      reverseWord[i] = forwardWord[forwardWord.length - 1 - i];

    return new String(reverseWord);
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
