// Time Complexity :O(N) Not N^2 because the iteration over each string to check if number or not has a limit because integer value has been expected as a return value.
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack  = new Stack<>();
        for(int i = 0;i<tokens.length;i++){
            if(isNumeric(tokens[i])){
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }
            else{
                if(tokens[i].charAt(0)=='+'){
                    int a =stack.pop();
                    int b =stack.pop();
                    stack.push(b+a);
                }
                else if(tokens[i].charAt(0)=='-'){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b-a);
                }
                else if(tokens[i].charAt(0)=='*'){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b*a);
                }
               else if(tokens[i].charAt(0)=='/'){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                }
            }
        }
        return stack.pop();
    }
    private boolean isNumeric(String str){
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
}