// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String removeKdigits(String num, int k) {
        int removeDigits = k;
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char currChar = num.charAt(i);
            // we keep comparing the current number with the top of stack value
            // if current number is less than the top of the stack, we push it
            // else we pop the top of the stack and push the current number
            while (!s.isEmpty() && removeDigits > 0 && Character.getNumericValue(s.peek()) > Character.getNumericValue(currChar)) {
                s.pop();
                removeDigits--;
            }
            s.push(currChar);
        }
        // if all the subsequent digits are in non-decreasing order,
        // we remove the last k/remaining k digits from the top of the stack
        while (removeDigits > 0) {
            s.pop();
            removeDigits--;
        }
        Iterator curr = s.iterator();
        // we iterate on the stack, forming the resultant number
        StringBuilder res = new StringBuilder();
        while (curr.hasNext()) {
            res.append(curr.next());
        }
        String finalString = res.toString();
        // if there's any leading zeros, we should remove it
        return finalString.length() > 0 ? finalString.replaceAll("^0+(?!$)", "") : "0";
    }
}
