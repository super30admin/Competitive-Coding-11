//time complexity:O(n)
//space complexity:O(n)

class Solution {
    public int evalRPN(String[] tokens) {
        //edge 
        if(tokens ==null || tokens.length==0) return 0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++)
        {
             if(tokens[i].equals("+"))
            {
                if(!st.isEmpty()&& st.size()!=1)
                {
                    int num=0;
                    num=st.pop();
                    num+=st.pop();
                    st.push(num);
                }
             }
             else if(tokens[i].equals("*"))
            {
                if(!st.isEmpty() && st.size()!=1)
                {
                    int num=0;
                     num=st.pop();
                     num*=st.pop();
                    st.push(num);
                }
             }
             else if(tokens[i].equals("-"))
            {
                 if(!st.isEmpty() && st.size()!=1)
                {
                   int num=0;
                   int num2=0;
                    num=st.pop();
                    num2=st.pop();
                    st.push(num2-num);
                 }
            }
             else if(tokens[i].equals("/"))
            {
                if(!st.isEmpty() && st.size()!=1)
                {
                   int num=0;
                    int num2=0;
                     num=st.pop();
                     num2=st.pop();
                    st.push(num2/num);
                }
             }
            else
            {
                 int elem=Integer.parseInt(tokens[i]);
                 st.push(elem);
            }
            
        }
        return st.pop();
    }
}
