// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Remove K Digits
// Time - O(n)
//space - O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0){
            return "";
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(char c: num.toCharArray()){
            while(!stack.isEmpty() && (c - '0') < stack.peek() && k > 0){
                stack.pop();
                k--;
            }
            stack.push(c - '0');
        }
        // if k is left
        for(int i=0; i<k; ++i) {
            stack.pop();
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        //Check for trailing zeros
        int i = 0;
        while(i < sb.length() && sb.charAt(i) == '0'){
            i++;
        }
        return sb.substring(i).length() == 0 ? "0" : sb.substring(i).toString();
    }
}
//Evaluate Reverse Polish Notation
// Time - O(n)
// Space - O(n)
class Solution {
    
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
           
            if("+-*/".contains(token)){
                int num2 = stack.pop();
                int num1 = stack.pop();
                long res = 0;
                switch(token){
                    case "+": res = num1 + num2;
                            break;
                    case "-": res = num1 - num2;
                            break;
                    case "*": res = num1 * num2;
                            break;
                    case "/": res = num1 / num2;
                            break;
                }
                stack.push((int) res);
            }else{
                //isdigit
                stack.push(Integer.valueOf(token));
            }
                 
        }
        
        
        return stack.pop();
    }
}