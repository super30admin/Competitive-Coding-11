Time Complexity = O(n)
Space Complexity = O(1)

class Solution {
    public String removeKdigits(String num, int k) {
        int size = num.length();
        if(k == size)return "0";
        Stack<Character> stack = new Stack<>();
        
        int cnt = 0;
        while(cnt < size){
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(cnt)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(cnt));
            cnt++;
        }
        
        while(k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            char current_char = stack.pop();
            sb.append(current_char);
        }
        
        sb.reverse();
        
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
        
    }
}