import java.util.*;
public class leetcode46
{
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        // permutation(new int[]{1,2}, result, new HashSet<>(), new ArrayList<>());
        permutation("abc", result, new HashSet<>(), new String());
        System.out.println(result);
    }
    public static void permutation(int[] nums, List<List<Integer>> result , HashSet<Integer> set, List<Integer> list)
    {
        if(set.size() == nums.length)
        {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++)
        {
            if(!set.contains(nums[i]))
            {
                set.add(nums[i]);
                list.add(nums[i]);
                permutation(nums, result, set, list);
                list.remove(list.size()-1);
                set.remove(nums[i]);
            }
          
        }
    }

    //for String
     public static void permutation(String unSorted, List<String> result , HashSet<Character> set, String Sorted)
    {
        if(unSorted.length() == 0)
        {
            
            result.add(Sorted);
            return;
        }

        for(int i=0; i<unSorted.length(); i++)
        {
          if(!set.contains(unSorted.charAt(i)))
          {
            set.add(unSorted.charAt(i));
            Sorted += unSorted.charAt(i);
            permutation(unSorted.substring(i+1), result, set,Sorted);
            Sorted = Sorted.substring(0, Sorted.length()-1);
            set.remove(unSorted.charAt(i));
          }
          
        }
    }
}