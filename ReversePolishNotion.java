/**
TC-O(N), SC - O(N)
*/
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;

        for(String token : tokens){
            
                    if(token.equals("+")){
                        int num1 = st.pop();
                        int num2 = st.pop();
                        int res = num1+num2;
                        st.push(res);
                    }
                    else if(token.equals("-")){
                        int num1 = st.pop();
                        int num2 = st.pop();
                        int res = num2-num1;
                        st.push(res);
                    }
                    else if(token.equals("*")){
                        int num1 = st.pop();
                        int num2 = st.pop();
                        int res = num1*num2;
                        st.push(res);
                    }else if(token.equals("/")){
                        int num1 = st.pop();
                        int num2 = st.pop();
                        int res = num2/num1;
                        st.push(res);
                    }
                    else{
                        int num = Integer.parseInt(String.valueOf(token));
                        st.push(num);
                    }
                
            
        }
        return st.pop();

    }
   
}
