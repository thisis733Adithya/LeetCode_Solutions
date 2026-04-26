// 22. Generate Parentheses Solved

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]
 

// Constraints:

// 1 <= n <= 8

 public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        parenthesis(0, 0 , n, result, new StringBuilder());
        return result;  
    }
    private void parenthesis(int open ,int close, int n, List<String> result, StringBuilder s){
        if(open == close && close == n){
            result.add(s.toString());
            return;
        }
        if(open < n){
            s.append("(");
            parenthesis(open+1 , close, n, result, s);
            s.deleteCharAt(s.length()-1);
        }

        if(close < open){
            s.append(")");
            parenthesis(open , close+1 , n, result, s);
            s.deleteCharAt(s.length()-1);
        }

    }
