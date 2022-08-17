// Time Complexity : O(N)
// Space Complexity : O(N)

class Solution {

    Stack<Integer> st = new Stack<>();
    public int evalRPN(String[] tokens) {

        for(int i=0;i<tokens.length;i++){

            String s = tokens[i];

            if(s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")){

                int i1 = st.pop();
                int i2 = st.pop();
                evaluate(i1, i2, s);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();

    }

    private void evaluate(int i1, int i2, String op){
        if(op.equals("+")){
            st.push(i1 + i2);
        }else if(op.equals("/")){
            st.push(i2 / i1);
        }else if(op.equals("-")){
            st.push(i2 - i1);
        }else{
            st.push(i1 * i2);
        }
    }
}