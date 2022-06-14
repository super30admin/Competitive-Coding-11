class Solution {

    // Time Complexity : 0(n) where n is the length of the string
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();  //I am taking a stack to store all the operands and the operations carried out among them
        HashSet<String> set = new HashSet<>();  //A hashset to to store different operators
        set.add("+");   //adding all the operators to my stack
        set.add("-");
        set.add("*");
        set.add("/");
        for(String s : tokens){ //traversing through the string
            if(set.contains(s)){    //if it is an operator
                int a = st.pop();   //then I am popping the top 2 elements in my stack to perform the operation or performing the operation in the last 2 elements in the string before an operator is encountered
                int b = st.pop();
                if(s.equals("+")){  //performing addition if I encounter + and then pushing it back onto to the stack for further operations
                    st.push(b + a);
                }
                if(s.equals("-")){  //performing substraction and so on
                    st.push(b - a);
                }
                if(s.equals("*")){
                    st.push(b * a);
                }
                if(s.equals("/")){
                    st.push(b / a);
                }
            }
            else{
                st.push(Integer.parseInt(s));   //If the element encountered in the string is not an operator means it's an integer, So I push it on to the stack
            }
        }
        return st.pop();    //there will be the final answer left at the bottom of my stack after all the operations have been performed
    }
}