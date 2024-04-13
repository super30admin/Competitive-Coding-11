// TC=O(n)
// SC=O(n)
class Solution {
    public int evalRPN(String[] t) {
        Stack<Integer> st = new Stack<>();
        int n = t.length; int r = 0;
        for(int i = 0; i < n; i++){
            if(!(t[i].equals("+") || t[i].equals("-") || t[i].equals("*") || t[i].equals("/"))){
                int conv = Integer.parseInt(t[i]);
                st.push(conv);
            }else{
                int a =st.pop();
                int b = st.pop();
                // int r = a t[i] b;
                if(t[i].equals("+")){
                   r = a + b;
                   st.push(r);
                } else  if(t[i].equals("-")){
                   r = b - a;
                   st.push(r);
                } else  if(t[i].equals("/")){
                   r = b / a;
                   st.push(r);
                } else{
                    r = b * a;
                   st.push(r);
                }
               
            }
        }
        return st.pop();
    }
}