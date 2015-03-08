import java.util.*;

public class Problem5 {

  //Paramter(s): int[] coconutVolumes - The volumes of available coconuts
  //             int   max            - The maximum number of coconuts that
  //                                    Gary can hold.
  //Return:      int                  - The volume of coconut water he can drink
  public static int poweredByCoconuts(int[] coconutVolumes, int max) {
    // Essentially, we need to get the max greatest items from the 
    // coconut volumes array. This should be easy if we put it in a 
    // max-heap.
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(new
        Comparator<Integer>() {
          public int compare(Integer i, Integer j) {
            return i >= j ? -1 : 1;
          }
        });
    for (int i = 0; i < coconutVolumes.length; ++i)
      maxheap.add(coconutVolumes[i]);

    int result = 0;
    int counter = 0;
    while (counter < max && maxheap.peek() != null) {
      result += maxheap.poll();
      counter++;
    }
    
    return result;
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
        for (int i = 0; i < volumes.length; ++i) {
          if (!volumes[i].equals(""))
            volumeInts[i] = Integer.parseInt(volumes[i]);
        }

        System.out.println(poweredByCoconuts(volumeInts,
              Integer.parseInt(followingLine)));
      }
    }
  }

}
