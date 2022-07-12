//Time -O(n)
//Space - O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for( int i=0; i< tokens.length; i++){
            if(tokens[i].equals("*")){
                int m = st.pop();
                int n = st.pop();
                st.push(m*n);
            } else if(tokens[i].equals("+") ){
                int m = st.pop();
                int n = st.pop();
                st.push(m+n);
            } else if( tokens[i].equals("/")){
                int m = st.pop();
                int n = st.pop();
                st.push(n/m);
            }else if(tokens[i].equals("-")){
                 int m = st.pop();
                int n = st.pop();
                st.push(n-m);
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}