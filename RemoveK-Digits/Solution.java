//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Greedy, Using stack
 */
class Solution {
    public String removeKdigits(String num, int k) {
        
        LinkedList<Character> stack = new LinkedList<>();
        
        for(char c: num.toCharArray()) {
            while(stack.size()>0 && k>0 && stack.peekLast() > c) {
                stack.removeLast();
                    k--;
            }
            stack.addLast(c);
        }
        
        for(int i=0; i<k; i++) {
            stack.removeLast();
        }
        
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        
        for(char c: stack) {
            if(leadingZero && c == '0') 
                continue;
            leadingZero = false;
            result.append(c);
        }
        
        if(result.length() == 0) return "0";
        return result.toString();
    }
}