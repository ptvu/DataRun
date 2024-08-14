import java.util.*;

public class Solution719 {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int furthest = nums[nums.length - 1] - nums[0];
        int lower = 0;
        int higher = furthest;
        while (lower < higher) {
            int mid = (lower + higher) / 2;
            // return how many pairs are <= mid
            int count = howManyPairsFast(nums, mid);
            if (count >= k) {
                higher = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }
    private static int howManyPairsFast(int[] nums, int limit) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {            
            if (j <= i) {
                j = i + 1;
            }
            if (nums[j] - nums[i] <= limit) {
                while (j + 1 < nums.length && nums[j + 1] - nums[i] <= limit) {
                    j = j + 1;
                }
                count = count + (j - i);
            }
        }
        return count;
    }
    @SuppressWarnings("unused")
    private static int howManyPairs(int[] nums, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] <= mid) {
                    count = count + 1;
                }
            }
        }
        return count;
    } 
}
