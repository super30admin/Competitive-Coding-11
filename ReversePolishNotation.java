/*
time complexity : O(n)
space complexity :O(n)
approach : we evaluate the expression by putting it into stack and as soon as
an operator comes we pop out two operands, perform the operation and then push
the result back to the stack.
}
*/


class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null){
            return 0;
        }

        Stack<Integer> st = new Stack<Integer>();


        for(int i = 0; i< tokens.length; i++){
            if(tokens[i].equals("+")){
                int first = st.pop();
                int second = st.pop();
                st.push(first+second);
            }
            else if(tokens[i].equals("*")){
                 int first = st.pop();
                int second = st.pop();
                st.push(first*second);
            }
            else if(tokens[i].equals("-")){
                 int first = st.pop();
                int second = st.pop();
                st.push(second-first);
            }
            else if(tokens[i].equals("/")){
                 int first = st.pop();
                int second = st.pop();
                st.push(second/first);
            }
            else{
               st.push(Integer.parseInt(tokens[i]));
            }
        }

      return st.pop();

    }
}
