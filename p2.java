// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> op = new Stack();
        
        int temp = Integer.parseInt(tokens[0]);
        int res = temp;
        int length = tokens.length;
//Go through all the number and calculate result for last two numbers, when sign come. Push the result in stack again
        for(int i = 1; i<length;i++){
            if(tokens[i].equals("+")){
                temp = temp+op.pop();
            } else if(tokens[i].equals("-")){
                temp = op.pop()-temp;
            }else if(tokens[i].equals("*")){
                temp = op.pop()*temp;
            }else if(tokens[i].equals("/")){
                temp = op.pop()/temp;
            }else{
            op.push(temp);
            temp = Integer.parseInt(tokens[i]);}
        }

        return temp;
    }
}