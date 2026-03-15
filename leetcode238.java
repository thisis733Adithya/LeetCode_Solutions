

public class leetcode238 {
    public static void main(String[] args) {

        int [] result = productExceptItself(new int[]{1,2,2,3,4});
        for(int i:result)
        {
            System.out.print(i+"\t");
        }
        
    }
    public static int[] productExceptItself(int []nums)
    {
        int zeroCount = 0;
        int prod = 1;
        int prodWZero = 1;
        for(int i:nums){
            prod *= i;
            zeroCount = i == 0 ? zeroCount+1:zeroCount;
            if(i != 0)
            {
                prodWZero *= i;
            }
        }

        if(zeroCount ==  0)
        {
           for(int i=0; i<nums.length; i++)
            {
                nums[i] = prod / nums[i];
            }

        }else if(zeroCount == 1)
        {
            for(int i=0; i<nums.length; i++)
            {
                if(nums[i] == 0)
                {
                    nums[i] =prodWZero;
                }
                else{
                    nums[i] = 0;
                }
            }

        }else{
            
             for(int i=0; i<nums.length; i++)
            {
                nums[i] = 0;
            }
        }

        return nums;
    }

    // private static int oneZeroProduct(int[] num)
    // {
    //     int p = 1;
    //       for(int i=0; i<num.length; i++)
    //         {
    //             if(num[i] != 0)
    //             {
    //                 p*=num[i];
    //             }
    //         }
    //     return p;
    // }
   

}
