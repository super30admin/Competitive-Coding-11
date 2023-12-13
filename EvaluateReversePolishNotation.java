// Time Complexity : O(n)
// Space Complexity : O(n)
// n is the length of given input logs
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approac

class Solution {
    Stack<Integer> st = new Stack<>();
    public int evalRPN(String[] tokens) {
        for(int i = 0 ; i < tokens.length ; i++){
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ){
                int a = st.pop();
                int b = st.pop();
                calculate(a,b,s);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }

    private void calculate(int i , int j , String operation){
        if(operation.equals("+")){
            st.push(i+j);
        }
        else if(operation.equals("-")){
            st.push(j-i);
        }
        else if(operation.equals("*")){
            st.push(i*j);
        }
        else{
            st.push(j/i);
        }
    }
}
