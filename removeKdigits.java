class Solution {
    public String removeKdigits(String num, int k) {
        if(k==0) return num;
        
        Stack<Integer> st = new Stack<>();
        int i=0;
        for(;i<num.length() && k>0;i++){
            char c = num.charAt(i);
            while(!st.isEmpty() && st.peek()>c-'0' && k>0){
                st.pop();k--;
            }
            st.push(c-'0');
        }
        while(k>0){
            st.pop();k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        while(i<num.length()){
            sb.append(num.charAt(i++));
        }

        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
