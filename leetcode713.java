import java.util.*;

public class leetcode713 {

    public static void main(String[] args) {
        int result = subarrayProduct(new int[]{10,5,2,6}, 0);
        System.out.println("The Result : "+result);
    }
    /*713. Subarray Product Less Than K
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106 */

public static int subarrayProduct(int []nums, int k)
{
    Set<Integer> set = new HashSet<>();
    int prod = 1;
    int count= 0;
    int prev = 0;
    for(int next=0; next<nums.length; next++)
    {
        if(nums[next] < k)
        {
            set.add(nums[next]);
            count++;
        }
        prod = prod * nums[next];
        set.add(prod);
        while(prod >= k && prev < nums.length)
        {
            prod = prod / nums[prev];
            prev++;
        }
       
        if(prod < k && !set.contains(prod))
        {
            count++;
        }
        
    }

    while(prev < nums.length){
        // if(prod < k)
        // {
        //     count++;
        // }
        prod = prod / nums[prev];
         if(prod < k)
        {
            count++;
        }
        prev++;
    
    }
    return count;
}
}
