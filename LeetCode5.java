5. Longest Palindromic Substring
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.


  Code :

     public String longestPalindrome(String s) {
        String result = "";
        int length =0;
        for(int i=0; i<s.length(); i++){
            int l = i;
            int r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                if((r - l)+ 1 > length){
                result = s.substring(l, r+1);
                length = (r - l) + 1;
                }
                l--;
                r++;
            } 

            l = i;
            r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                if((r - l)+ 1 > length){
                result = s.substring(l, r+1);
                length = (r - l) + 1;
                }
                l--;
                r++;
            } 

            



        }
        

        return result;
    }


