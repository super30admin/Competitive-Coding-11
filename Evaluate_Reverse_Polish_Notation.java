// TC : O(n)
// SC : O(n) - stack space

class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if(n == 0 || tokens == null) return 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(String str : tokens) {
            
            if(str.equals("+") || str.equals("-") || str.equals("*") 
               || str.equals("/")) {
                
                if(!st.isEmpty()) {
                    int num1 = st.pop();
                    int num2 = st.pop();
                    if(str.equals("+")) {
                        num1 = num1 + num2;
                        st.push(num1);
                    }
                    else if(str.equals("-")) {
                        num1 = num2 - num1;
                        st.push(num1);
                    }
                    else if(str.equals("*")) {
                        num1 = num1 * num2;
                        st.push(num1);
                    }
                    else {
                        num1 = num2 / num1;
                        st.push(num1);
                    }
                }
                
            }
            
            else {
                //System.out.println(str);
                int temp = Integer.parseInt(str);
                st.push(temp);
            }
            
        }
        return st.pop();
    }
}
