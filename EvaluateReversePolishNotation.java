class Solution {
    int val = 0;
    Stack<Integer> st = new Stack<>();
    public int evalRPN(String[] tokens) {
        for(int i=0;i<tokens.length;i++){
            String c = tokens[i];
                if(c.equals("+")){
                    st.push(st.pop()+st.pop());
                }
                else if(c.equals("-")){
                    st.push(-1*st.pop()+st.pop());
                }
                else if(c.equals("*")){
                    st.push(st.pop()*st.pop());
                }
                else if(c.equals("/")){
                    int first = st.pop();
                    int second = st.pop();
                    st.push(second/first);
                }
                else{
                    st.push(Integer.parseInt(c));
                }
        }
        return st.pop(); 
    }
}


//["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
// 22

//Time complexity : O(N)
//Space complexity : O(N)
