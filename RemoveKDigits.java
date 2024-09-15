/*
O(S) space and time
Approach:
========
1. Iterate through characters in string, by comparing them with next ones, and keep pushing to stack 
2. As long as stack's top is larger than current element, keep popping till k is 0
3. Only k elements are left in stack if not equal
4. If equal, pop till k is 0 and remove any leading zeroes after pushing to stringbuilder and reversing it
*/
class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || k >= num.length()) return "0"; 
        
        Stack<Character> stack = new Stack<>(); 
        
        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i); 
            //recurse till smaller element is on stack top
            while(k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        
        //when all digits are equal, delete till there only k elements in stack
        while(k > 0) {
            stack.pop(); 
            k--;
        }
        
        //add to stringbuilder and reverse to get the min value
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop()); 
        }
        sb.reverse();

        //remove leading 0's
        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        
        return sb.toString(); 
        
    }
}