public class leetcode55 {
    public static void main(String[] args) {
        boolean result = canJump(new int[]{3,2,1,0,4});
        System.out.println("The Result : "+result);
    }
    public static boolean canJump(int []num)
    {
        int lastIndex = num.length-1;
        for(int i=0; i<num.length-1; i++)
        {
            int idx = i;
            idx += num[i];
            if(idx == lastIndex)
            {
                return true;
            }
        }
        return false;
    }
}
