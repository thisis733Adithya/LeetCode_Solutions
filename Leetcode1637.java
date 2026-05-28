// 1637. Widest Vertical Area Between Two Points Containing No Points
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.

// A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.

// Note that points on the edge of a vertical area are not considered included in the area.

//   Input: points = [[8,7],[9,9],[7,4],[9,7]]
// Output: 1
// Explanation: Both the red and the blue area are optimal.
// Example 2:

// Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
// Output: 3

public int maxWidthOfVerticalArea(int[][] points) {
        // [8,7],[9,9],[7,4],[9,7]]
        // 7,8,9,9
        // 1

        // Ex 2 :  
        // [[3,1],
        // [9,0],
        // [1,0],
        // [1,4],
        // [5,3],
        // [8,8]]
        // 0,1,1,3,5,8,9
        int [] arr = new int[points.length];
        for(int i=0; i<points.length; i++){
           arr[i] = points[i][0];
        }
       Arrays.sort(arr);
        int maxLength =0;
        for(int i=1; i<arr.length;  i++)
        {
         if( arr[i]-arr[i-1] > maxLength)
         {
            maxLength = arr[i]-arr[i-1];
         }
        }

        return maxLength;
    }
