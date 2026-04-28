// 1812. Determine Color of a Chessboard Square
  
// You are given coordinates, a string that represents the coordinates of a square of the chessboard. Below is a chessboard for your reference.
// Return true if the square is white, and false if the square is black.
// The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number second.

// Example 1:

// Input: coordinates = "a1"
// Output: false
// Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.
// Example 2:

// Input: coordinates = "h3"
// Output: true
// Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.
// Example 3:

// Input: coordinates = "c7"
// Output: false
 

// Constraints:

// coordinates.length == 2
// 'a' <= coordinates[0] <= 'h'
// '1' <= coordinates[1] <= '8'




public boolean squareIsWhite(String coordinates) {
        int num2 = (int)coordinates.charAt(1) - '0';
        char c = coordinates.charAt(0);
        int num1 = 0;
        switch(c){
            case 'a': num1 = 1;
            break;
            case 'b': num1 = 2;
            break;
            case 'c': num1 = 3;
            break;
            case 'd': num1 = 4;
            break;
            case 'e': num1 = 5;
            break;
            case 'f': num1 = 6;
            break;
            case 'g': num1 = 7;
            break;
            case 'h': num1 = 8;
            break;
            default : break;
        }
        if((num1 % 2 == 0 && num2 % 2 == 0 )||
       (num1 % 2 != 0 && num2 % 2 != 0 )){
        return false;
       }
       return true;
    
    }
