//Time and space complexity: O(n)

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0){
            return 0;
        }
        Stack<Integer> st=new Stack();
        for(String s:tokens){
            if(s.equals("+")){
                int i=st.pop();
                int j=st.pop();
                st.push(i+j);
            }
            else if(s.equals("-")){
                int i=st.pop();
                int j=st.pop();
                st.push(j-i);
            }
            else if(s.equals("*")){
                int i=st.pop();
                int j=st.pop();
                st.push(i*j);
            }
            else if(s.equals("/")){
                int i=st.pop();
                int j=st.pop();
                st.push(j/i);
            }
            else{
                int n=Integer.parseInt(s);
                st.push(n);
            }
        }
        return st.peek();   
    }
}