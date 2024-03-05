/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
    n - length of the string
* 
* Space Complexity: O(n)
* 
*/

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        Stack<Integer> st = new Stack<>();

        int index = 0;

        while (index < num.length()) {
            int incoming = num.charAt(index) - '0';

            while (!st.isEmpty() && st.peek() > incoming && k > 0) {
                st.pop();
                k--;
            }

            st.push(incoming);

            index++;
        }

        StringBuilder result = new StringBuilder();

        while (!st.isEmpty()) {
            if (k > 0) {
                st.pop();
                k--;
            } else {
                result.insert(0, st.pop());
            }
        }

        String resultStr = result.toString();

        System.out.println(resultStr);

        index = 0;

        while (index < resultStr.length()) {
            if (resultStr.charAt(index) != '0') {
                break;
            }

            index++;
        }

        resultStr = resultStr.substring(index);

        return resultStr.equals("") ? "0" : resultStr;
    }
}