Remove K Digits
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

        Example 1:

        Input: num = "1432219", k = 3
        Output: "1219"
        Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
        Example 2:

        Input: num = "10200", k = 1
        Output: "200"
        Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

TC: O(n) where n is the size of input string
SC: O(n) stack space


class Solution {
    public String removeKdigits(String num, int k) {
        if(num==null || num.length()==0 || num.length()==k) return "0";

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<num.length(); i++){
            char c = num.charAt(i);
            while(k>0 && !stack.isEmpty() && stack.peek()>c){
                stack.pop();
                k--;
            }
            stack.add(c);
        }

        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());

        }
        sb.reverse();

        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);

        }
        return sb.toString();
    }
}