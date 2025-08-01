// Time complexity - O(n)
// Space - O(k)
// Solved on leetcode - yes
// faced any issues - No
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder s= new StringBuilder();
        for(int i=0;i<num.length();i++) {
            int currentNumber = num.charAt(i)- '0';
            while(k>0 && !stack.isEmpty() && num.charAt(stack.peek())- '0'> currentNumber) {
                stack.pop();
                k--;
            }
            stack.push(i);
        }

        while(k!=0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        while(!stack.isEmpty()) {
            s.append(num.charAt(stack.peek()));
            stack.pop();
        }
        s.reverse();
        int i=0;
        while(s.length() >0 && i<=s.length()-1 && s.charAt(i)-'0' == 0) {
            i++;
        }
        return (s.substring(i).toString() == "") ? "0" : s.substring(i).toString();
    }
}
