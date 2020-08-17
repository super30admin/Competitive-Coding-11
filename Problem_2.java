// Time complexity - O(n)
// Space complexity - O(n)

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int num1 = (st.pop());
                int num2 = (st.pop());
                st.push(num1+num2);
            }else if(s.equals("-")){
                int num1 =(st.pop());
                int num2 = (st.pop());
                st.push(num2 - num1);
            }else if(s.equals("/")){
                int num1 = (st.pop());
                int num2 = (st.pop());
                st.push(num2/num1);
            }else if(s.equals("*")){
                int num1 = (st.pop());
                int num2 = (st.pop());
                st.push(num1*num2);
            }else{
                int num = Integer.parseInt(s);
                st.push(num);
            }   
        }
        return st.peek();        
    }
}
