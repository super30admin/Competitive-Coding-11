class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int n=tokens.length;
        int res=0;
        for(String ch:tokens){
            if(ch.equals("+")||ch.equals("-")||ch.equals("*")||ch.equals("/")){
                int temp2=st.pop();
                int temp1=st.pop();
                res=helper(temp1,temp2,ch);
                st.add(res);
            }else{
                int p=Integer.parseInt(ch);
                st.add(p);
            }
        }
        return st.pop();
    }
    public int helper(int temp1,int temp2,String ch){
        if(ch.equals("+")){
            return temp1+temp2;
        }else if(ch.equals("-")){
            return temp1-temp2;
        }else if(ch.equals("*")){
            return temp1*temp2;
        }else{
            return temp1/temp2;
        }
    }
}
