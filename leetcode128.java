
import java.util.HashSet;


public class leetcode128 {
    public static void main(String[] args) {
        int result = longestConsecutive(new int[]{0,1,2,3,5,6,7,8,9,1});
        System.out.println("The Result is : "+result);
        
    }
//  128. Longest Consecutive Sequence
// Medium
// Topics
// premium lock icon
// Companies
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
// Example 3:

// Input: nums = [1,0,1,2]
// Output: 3
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109

public static int longestConsecutive(int[] nums) {
    //This Solution is not optimal
    if(nums.length ==0) return 0;
    HashSet<Integer> set = new HashSet<>();
    for(int i:nums)
    {
        set.add(i);
    }
    int start = Min(nums);
    int end = Max(nums);
    int count =0;
    int prev = 0;
    for(int i=start; i<=end; i++)
    {
        if(set.contains(i))
        {
            count++;
        }
        else{
            prev = Math.max(prev, count);
            count = 0;
        }
    }
    prev = Math.max(prev, count);
     
return prev;    
}
private static int Min(int[] nums)
{
    int min = nums[0];
    for(int i:nums)
    {
        if(i < min)
        {
            min = i;
        }
    }
    return min;
}
private static int Max(int[] nums)
{
    int max = nums[0];
    for(int i:nums)
    {
        if(i > max)
        {
            max = i;
        }
    }
    return max;
}


}

