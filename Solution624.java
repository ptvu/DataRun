import java.util.*;

public class Solution624 {

    public static int maxDistance(List<List<Integer>> arrays) {
        int currentMin = Collections.min(arrays.get(0));
        int currentMax = Collections.max(arrays.get(0));
        int result = 0;
        int index = 0;
        for (List<Integer> list : arrays) {
            index = index + 1;
            if (index > 1) {
                int thisArraysMin = Collections.min(list);
                int thisArraysMax = Collections.max(list);
                int d1 = Math.abs(thisArraysMax - currentMin);
                int d2 = Math.abs(thisArraysMin - currentMax);
                result = Math.max(result, Math.max(d1, d2));

                currentMin = Math.min(currentMin, thisArraysMin);
                currentMax = Math.max(currentMax, thisArraysMax);
            }
        }
        return result;
    }
  
}
