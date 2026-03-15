import java.util.ArrayList;
import java.util.List;

public class leetcode77 {

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        System.out.println(result);
    }
    /*77. Combinations
Medium
Topics
premium lock icon
Companies
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

Constraints:

1 <= n <= 20
1 <= k <= n */
 public static  List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combination( n, k, result, new ArrayList<>() , 1);
        return result;
        
    }
    private static void combination(int n, int k, List<List<Integer>> result, List<Integer> list, int startIndex)
    {
        if(k == 0)
        {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=startIndex; i<=n; i++)
        {
            list.add(i);
            combination( n, k-1, result, list,i + 1);
            list.remove(list.size()-1);
        }
    }
}
