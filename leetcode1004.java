public class leetcode1004 {

    public static void main(String[] args) {
        int result = longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
        System.out.println("The max Count : "+ result);
    }
    /*1004. Max Consecutive Ones III
Medium
Topics
premium lock icon
Companies
Hint
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length */
public static int longestOnes(int[] nums, int k) {
    int maxCount = 0;
    int flipCount = 0;
    int left = 0;
    int placeLeft = left;
    int placeRight = 0;
    for(int right=0; right<nums.length; right++)
    {
        //Fliping
        if(flipCount <=k &&nums[right] == 0)
        {
           nums[right] = 1;
            flipCount++;
        }
        placeLeft = left;
        placeRight = right;

        if(flipCount > k &&nums[right] == 0)
        {
         placeLeft = left;
         placeRight = right-1;
         left = right;
         flipCount = 0;
         //Fliping the Current Element 
         nums[right] = 1;
         flipCount++;

        }

        maxCount = Math.max(maxCount, (placeRight - placeLeft + 1));
    }
    return  maxCount;
    }
}
