// Time And Spcae O(N)

class Solution {
    public String removeKdigits(String num, int k) {
         if(k == num.length())
            return "0";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<num.length(); i++){
            int nums = Character.getNumericValue(num.charAt(i));
           while( k>0 && !st.isEmpty() && nums < st.peek()) {
               k--;
                st.pop();
            }
            st.push(nums);
        }
          while(k>0){
            k--;
            st.pop();
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}


