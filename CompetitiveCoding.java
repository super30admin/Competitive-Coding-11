import java.util.*;
public class CompetitiveCoding{
     // time complexity: N
    // space complexity : N
    // any doubts : no
    // did it run on leetcode : yes
    //https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/
    public int evalRPN(String[] tokens) {
        HashSet<String> set = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        set.add("*");
        set.add("+");
        set.add("/");
        set.add("-");
        for(String s : tokens){
            
            if(set.contains(s)){
                int second = st.pop();
                int first = st.pop();
                if(s.equals( "*")){
                    st.push(first*second);
                }else if(s.equals( "/")){
                    st.push(first/second);
                }else if(s.equals( "+")){
                    st.push(first + second);
                }else if(s.equals( "-")){
                    st.push(first - second);
                }
                
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
        
    }

    //time complexity : Nk 
    // space complexity : N
    // did it run on leetcode : yes
    // any doubt : no
    // https://leetcode.com/problems/remove-k-digits/submissions/
    public String removeKdigits(String num, int k) {
        if(k==0) return num;
        if(num.length()== k ) return "0";
        Stack<Character> st = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i =0;i<num.length();i++){
            char c = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()>c){              
                st.pop();
                k--;
                
            }
            st.push(c);  
        }
        
        for(int i=0; i<k; ++i) {
            if(!st.isEmpty()){
                st.pop();
            }
            
         }
        while(!st.isEmpty()){
            st2.add(st.pop());
        }
        boolean leadingzero = true;
        while(!st2.isEmpty()){
            if(leadingzero && st2.peek()=='0'){
                st2.pop();
                continue;
            } 
            
            leadingzero = false;
            res.append(st2.pop());
        }
        if(res.length()==0) return "0";
        
        
        
        return res.toString();
        
    }
}