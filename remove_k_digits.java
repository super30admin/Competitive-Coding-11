

// Time Complexity : O(2n+K) ~ O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Brute force solution was to find every possible combincation of the n-2 digits this is exponential solution. To optimize furhter we can use use because the order.


// Your code here along with comments explaining your approach



class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(char digit: num.toCharArray()){
         while(stack.size() > 0 && k > 0 && stack.peek() > digit){ 
            stack.pop();
            k-=1;
         }
        stack.push(digit);
        }
        
        
        for(int i=0; i<k; i++){
            stack.pop();
        }
        
        StringBuilder result = new StringBuilder();
        boolean leadingZeros = true;
        
        for(char digit: stack){
            if(leadingZeros && digit=='0') continue;
            leadingZeros = false;
            result.append(digit);
        }
        
        if(result.length() == 0) return "0";
        return result.toString();
        
    }
}