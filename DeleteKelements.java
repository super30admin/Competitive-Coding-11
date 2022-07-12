//Time -O(N)
//space - O(N)
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack <>();
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i< num.length(); i++){
            int c = num.charAt(i) -'0';
            while(!st.isEmpty() && k>0 && st.peek()>c){
                st.pop();
                k--;
            }
            st.push(c);
        }
            while(k!=0){
                st.pop();
                k--;
            }
            while(!st.isEmpty()){
                result.append(st.pop());
            }
            
            result.reverse();
        
            while(result.length() > 1 && result.charAt(0) == '0'){
                result.deleteCharAt(0);
            }
           if(result.toString() == "") return "0";
 
            return result.toString();
            
        }
    }
