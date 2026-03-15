public class leetcode904 {

    public static void main(String[] args) {
        int result = totalFruit3(new int[]{0,1,2,2});
        System.out.println("The max Count : "+ result);
    }
    /*
904. Fruit Into Baskets
Medium
Topics
premium lock icon
Companies
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

 

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
 

Constraints:

1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length

     */

 public static int totalFruit(int[] fruits) {
        int left = 0;
        int maxCount = Integer.MIN_VALUE;
        int type1 = -1;
        int type2 =  -1;
        int countType1 = 0;
        int countType2 = 0;
        
        for(int right =0; right<fruits.length; right++ )
        {
            if(type1 == -1 && type2 == -1)
            {
                type1 = fruits[right];
                countType1++;
            }
            if(type1 != -1 && type2 == -1)
            {
                type2 = fruits[right];
                countType2++;
            }
            if(fruits[right] != type1 &&fruits[right] != type2){
                maxCount = Math.max(maxCount, countType1 + countType2 );
                while(fruits[left] != type2)
                {
                    left++;
                }
                type1 = type2;
                type2 = fruits[right];
            }
            if(fruits[right] == type1){ countType1++;}
            if(fruits[right] == type2){ countType2++;}
        }
        
        return maxCount;
    }

     public static int totalFruit2(int[] fruits) {
        if(fruits.length <= 2)
        {
            return fruits.length;
        }
        int left=0;
        int type1 = fruits[0];
        int i=0;
        while(fruits[i] == type1)
        {
            i++;
        }
        int type2 =  fruits[i];
        int maxCount = Integer.MIN_VALUE;

         //1,2,3,2,2,1
        for(int right=i+1; right < fruits.length; right++)
        {
            if(fruits[right] != type1 && fruits[right] != type2){
                //maxCount = Math.max(maxCount , (right - left));
                // while(fruits[left] != type2)
                // {
                //     left++;
                //    // maxCount--;
                // }
                left = right-1;
             //   maxCount = 0;
               type1 = type2;
                type2 = fruits[right];
            }

            maxCount = Math.max(maxCount, (right - left + 1));
        }

        return maxCount;
     }

     //


    public static int totalFruit3(int[] fruits) {
    if (fruits.length <= 2) {
        return fruits.length;
    }

    int left = 0;

    int type1 = fruits[0];
    int i = 0;

    // safeguard boundary
    while (i < fruits.length && fruits[i] == type1) {
        i++;
    }

    // all elements same
    if (i == fruits.length) {
        return fruits.length;
    }

    int type2 = fruits[i];
    int maxCount = 0;

    // iterate window
    for (int right = i + 1; right < fruits.length; right++) {

        // third fruit encountered
        if (fruits[right] != type1 && fruits[right] != type2) {

            // move left to start of last continuous block of type2
            int newLeft = right - 1;
            while (newLeft >= 0 && fruits[newLeft] == type2) {
                newLeft--;
            }
            left = newLeft + 1;

            // update fruit types
            type1 = type2;
            type2 = fruits[right];
        }

        maxCount = Math.max(maxCount, right - left + 1);
    }

    return maxCount;
}

public int totalFruit4(int[] fruits) {
    Map<Integer, Integer> map = new HashMap<>();
    int left = 0, max = 0;

    for (int right = 0; right < fruits.length; right++) {
        map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

        while (map.size() > 2) {
            map.put(fruits[left], map.get(fruits[left]) - 1);
            if (map.get(fruits[left]) == 0) {
                map.remove(fruits[left]);
            }
            left++;
        }

        max = Math.max(max, right - left + 1);
    }

    return max;
}
}   
