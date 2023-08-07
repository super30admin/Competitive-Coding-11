// TC=O(2n+k)-> O(n)
// Compare each number before adding to stack with the previously added one and delete the larger number till k becomes 0;
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<num.length();i++){
            int digit = Character.getNumericValue(num.charAt(i));
            while(!st.isEmpty() && st.peek()>digit && k>0){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        while(k>0){
            st.pop();
            k--;
        }
        int i = st.size()-1;
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){ //adding the stack elements in reverse manner to form the number 
            str.insert(0,st.pop());
            i--;
        }
        int j=0;
        while(j<str.length() && str.charAt(j)=='0'){ // removing leading zeros
            j++;
        }
        if(j>0){ // removing leading zeros
            str.delete(0,j);
        }
        if(str.isEmpty()) return "0"; //returning 0 for empty string i.e. ""
        return str.toString();
    }
}