import java.util.Stack;
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        //push into stack if alphabet
        //pop top two element and perform operation
        //push result of operation performed
        //return element in stack
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                int n1 = stk.pop();//5
                int n2 = stk.pop();//13
                if(s.equals("+") ){
                    stk.push(n1+n2);
                }
                else if(s.equals("-") ){
                    stk.push(n2-n1);
                }
                else if(s.equals("/")){
                    //4
                    stk.push(n2/n1);
                }
                else{
                    stk.push(n1*n2);
                }
            }
            else{
                stk.push(Integer.parseInt(s));
            }
        }
        return stk.pop();
    }
}
