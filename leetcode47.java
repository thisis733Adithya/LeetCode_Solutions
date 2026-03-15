import java.util.*;

public class leetcode47 {

    public static void main(String[] args) {
        List<List<Integer>> result = permuteUnique(new int[]{1,1,29});
        System.out.println(result);
    }
    /*47. Permutations II
Medium
Topics
premium lock icon
Companies
Given a collection of numbers, nums, that might contain duplicates,
 return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
     */
//Hint : Array
//Backtracking
//Sorting
 public static List<List<Integer>> permuteUnique(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();
    permutation(nums, result, new ArrayList<>(), new HashSet<>());
    return result;
}
private static void permutation(int []nums, List<List<Integer>> result, List<Integer> list, HashSet<Integer> set)
{
    if(list.size() == nums.length)
    {
       if(!result.contains(list)){
       result.add(new ArrayList<>(list));
       }
       
       return; 
    }

    for(int i=0; i<nums.length; i++)
    {
           if(!set.contains(i)){     
            set.add(i);
            list.add(nums[i]);
            permutation(nums, result, list,set);
            list.remove(list.size()-1); 
            set.remove(i);
            }      
    }
}
}
