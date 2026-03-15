

public class leetcode503 {
    public static void main(String[] args) {
        System.out.println("The result :");
        for(int i:nextGreaterElement(new int[]{1,2,3,4,3}))
        {
            System.out.print(i+"\t");
        }
        
    }
    public static int[] nextGreaterElement(int[] nums)
    {
       
        int n = nums.length;
        // List<Integer> list = new ArrayList<>();
        int []result = new int[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            boolean isFound = false;
            for(int j=(i+1)%n; j != i; j = (j+1)% nums.length)
            {
                if(nums[j] > nums[i])
                {
                    isFound = true;
                    result[i] = nums[j];   
                    break;
                }
            }
            if(!isFound)
            {
                result[i] = -1;
            }
        }

        return result;
    }
    
}
