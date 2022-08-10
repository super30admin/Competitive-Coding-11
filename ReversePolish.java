import java.util.Stack;

//Time Complexity=O(n)
//Space Complexity=O(n)
public class ReversePolish {

    public int evalRPN(String[] tokens) {
        if(tokens.length==1) return Integer.parseInt(tokens[0]);

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<tokens.length;i++){
            int curr,a,b;
            if(tokens[i].equals("/")){
                if(!st.isEmpty()){
                    a=st.pop();
                    b=st.pop();
                    curr=b/a;
                    st.push(curr);
                }
            }else if(tokens[i].equals("*")){
                if(!st.isEmpty()){
                    a=st.pop();
                    b=st.pop();
                    curr=b*a;
                    st.push(curr);
                }
            }else if(tokens[i].equals("+")){
                if(!st.isEmpty()){
                    a=st.pop();
                    b=st.pop();
                    curr=b+a;
                    st.push(curr);
                }
            }else if(tokens[i].equals("-")){
                if(!st.isEmpty()){
                    a=st.pop();
                    b=st.pop();
                    curr=b-a;
                    st.push(curr);
                }
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }

        }
        return st.pop();
    }
}
