//Time complexity : O(n)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0||tokens==null){
            return 0;
        }
        int result = 0;
        //use a stack to get the most recent  operands and their results
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            //if the current string is an operator, perform the respective operation
            if(!stack.isEmpty() && ("+-/*".contains(tokens[i]))){
                //remove the last two elements on which the operation needs to be performed
                    int pop2 = stack.pop();
                    int pop1 = stack.pop();
                    result = 0;
                //perform the operation
                    switch (tokens[i]) {
                        case "+":
                            result = pop1 + pop2;
                            break;
                        case "-":
                            result = pop1 - pop2;
                            break;
                        case "*":
                            result = pop1 * pop2;
                            break;
                        case "/":
                            result = pop1 / pop2;
                            break;
                    }
                //push the intermediate result
                stack.push(result);
            }
            //if its a number then push it to the stack
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        //the stack will have just one element wihich is the final result
        return stack.pop();
    }
}