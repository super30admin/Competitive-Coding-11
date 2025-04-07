// Time Complexity :O(n)
// Space Complexity :O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        if(k>num.length()) return "0";
        for(char digit :num.toCharArray()){
            while(!st.isEmpty()&&k>0&&st.peek()>digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        for(char digit:st){
            result.append(digit);
        }
        while(result.length()>0&&result.charAt(0)=='0'){
            result.deleteCharAt(0);
        }
        if(result.length()==0){
            return "0";    
        }
        else{
            return result.toString();
        }
    }
}