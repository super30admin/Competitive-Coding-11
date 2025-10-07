
// Time Complexity: O(n)
// Space Complexity: O(n)


// We use a stack to evaluate the expression in Reverse Polish Notation.
// We iterate through each token in the input array. If the token is a number, we push it onto the stack.
// If the token is an operator, we pop the top two elements from the stack, apply the operator, and push the result back onto the stack.
// At the end of the iteration, the stack will contain a single element which is the result of the RPN expression.

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if(!s.equals("+")&&!s.equals("-")&&!s.equals("*")&&!s.equals("/"))
                stk.push(Integer.parseInt(s));
            else{
                int a=stk.pop();
                int b=+stk.pop();
                if(s.equals("+"))
                    stk.push(a+b);
                else if(s.equals("-"))
                    stk.push(b-a);
                else if(s.equals("*"))
                    stk.push(a*b);
                else if(s.equals("/"))
                    stk.push(b/a);
            }
        }
       return stk.pop();
    }
}