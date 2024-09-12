//Greedy https://www.youtube.com/watch?v=vbM41Zql228&ab_channel=NickWhite
//TC:O(N) -> O(N) , N: num.length()
//SC:O(N) -> stack + stringbuilder size -> O(2N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len)
            return "0";
        Stack<Character> stack = new Stack();
        int i = 0;
        while ( i < len){
            char c = num.charAt(i);
            while ( k > 0 && !stack.isEmpty() && stack.peek() > c){
                stack.pop();
                k--;
            }
          
            stack.push(c);
            i++;
        }
        while ( k > 0){
          stack.pop();
          k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
    
        return sb.toString();
    }
}
