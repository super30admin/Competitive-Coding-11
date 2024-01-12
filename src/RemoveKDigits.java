// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    
    public String removeKdigits(String num, int k) {
        
        if(k == num.length())                                       // removing all character case
            return "0";
    
        Stack<Character> stack = new Stack<>();
        int i = 0;
    
        while(i<num.length()) {
            char ch = num.charAt(i);
            while(k>0 && !stack.isEmpty() && stack.peek()>ch) {     // while k>0, peek is greater
                stack.pop();                                        // keep removing peek
                k--;
            }
            stack.push(ch);                                         // else adding new character
            i++;
        }
    
        while(k>0) {                                                // if k>0 after reading all characters
            stack.pop();                                            // removing k characters left which would be in ascending order
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());                                 // stack to StringBuilder
        sb.reverse();                                               // reverse the StringBuilder
    
        while(sb.length()>1 && sb.charAt(0) == '0')                 // removing leading 0s with no value and unnecessary
            sb.deleteCharAt(0);
        return sb.toString();
    
    }

}
