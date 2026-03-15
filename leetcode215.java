import java.util.HashSet;
public class leetcode215 {
    public static void main(String[] args) {
        System.out.println("The Result : "+findKthLargest(new int[]{2,2,2,2,2,2,2,2,2,2,2,2}, 10));
    }
    public static int findKthLargest(int[] nums, int k)
    {  
        if(k > nums.length || nums.length == 0){ return -1;}
        HashSet<Integer> set = new HashSet<>();
        int max  = -1;
        for(int i=0; i<k; i++)
        {
            max = Max(nums, set);
        }
       return max;
    }
    private static int Max(int []nums, HashSet<Integer> set)
    {
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] > max && !set.contains(i))
            {
                max = nums[i];
                maxIdx = i;
            }
        }
        set.add(maxIdx);

        return max;
    } 
    
}
