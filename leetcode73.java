
import java.util.ArrayList;
import java.util.List;
public class leetcode73 {
// 73. Set Matrix Zeroes
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

 

// Example 1:


// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:


// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

// Constraints:

// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
 

// Follow up:

// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

public static void main(String[] args) {
    int arr[][] ={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    setZeroes(arr);
    System.out.println("The result :");
    for(int [] i:arr)
    {
        for(int val:i)
        {
            System.out.print(val+"\t");
        }
        System.out.println();
    }

}

public static void setZeroes(int[][] matrix) {
    List<List<Integer>> result = new ArrayList<>();

    for(int i=0; i<matrix.length; i++)
    {
        for(int j=0; j<matrix[0].length; j++)
        {
            if(matrix[i][j] == 0)
            {
                List<Integer> list = new ArrayList<>(2);
                list.add(i);
                list.add(j);
                result.add(list);
            }
        }
    }

    for(int i=0; i<result.size(); i++)
    {
        healper(matrix,result.get(i));
    }

        
    }

    private static void healper(int[][] matrix, List<Integer> list)
    {
        int row = list.get(0);
        int col = list.get(1);
        //making all row values Zero
        for(int i=0; i<matrix[0].length; i++)
        {
            matrix[row][i] = 0;
        }

        //making all column values Zero
         for(int i=0; i<matrix.length; i++)
        {
            matrix[i][col] = 0;
        }
    }
}
