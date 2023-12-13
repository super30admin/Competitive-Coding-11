//Time -> O(n)
//Space -> O(n)

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int a, b;
        for(String str: tokens){
            switch(str){
                case "+":
                    a = st.pop();
                    b = st.pop();
                    st.push(b+a);
                    break;
                case "-":
                    a = st.pop();
                    b = st.pop();
                    st.push(b-a);
                    break;
                case "*":
                    a = st.pop();
                    b = st.pop();
                    st.push(b*a);
                    break;
                case "/":
                    a = st.pop();
                    b = st.pop();
                    st.push(b/a);
                    break;
                default: 
                    st.push(Integer.parseInt(str));
        }
        }
        return st.pop();
    }
}
