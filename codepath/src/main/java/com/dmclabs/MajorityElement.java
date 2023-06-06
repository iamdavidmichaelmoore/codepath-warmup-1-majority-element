package com.dmclabs;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class MajorityElement {

    // MAIN METHOD
    public static void main(String[] args) {
        int[] nums1 = {3,2,3};
        int[] nums2 = {2,2,1,1,1,2,2};

        System.out.println(MajorityElement.majorityElement(nums1));
        System.out.println(MajorityElement.majorityElement(nums2));
    }

    //NOTE - Original Code
    public static int majorityElementOriginal(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                value = map.get(nums[i]);
                map.replace(nums[i],value,value+1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int maxKey = 0;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return maxKey;
    }

    //NOTE - Optimized Code
    /**
     * Finds and returns the value with the maximum mode.
     * @param nums
     * @return maximum mode value.
     * Implementation uses the Boyer-Moore Voting Algorithm
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}