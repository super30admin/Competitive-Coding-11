// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if(tokens[i].equals("-")){
                int sub = stack.pop();
                stack.push(stack.pop()-sub);
            }else if(tokens[i].equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if(tokens[i].equals("/")){
                int div = stack.pop();
                stack.push(stack.pop()/div);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}