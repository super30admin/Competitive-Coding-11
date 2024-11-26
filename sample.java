// Time Complexity : O(n) where n is the length of the num as each letter is being pushed or popped from the stack at least once.
// Space Complexity : O(n) as in the worst case scenario stack can hold upto n characters.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// The function removeKdigits removes k digits from the string num to form the smallest possible number. It uses a stack-based greedy approach to achieve this. 
// The algorithm iterates through each character in num, and for each character, it pops elements from the stack if the current character is smaller than the 
// top of the stack and k > 0. This ensures that larger digits are removed to allow smaller digits to remain, leading to a smaller overall number. After the 
// traversal, any remaining k digits are removed by popping from the stack. The stack elements are then reversed to get the correct order of digits. Finally, 
// leading zeros are removed by finding the first non-zero character. If the result is empty, "0" is returned.

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();

        if(k == n) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            char c = num.charAt(i);

            while(!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }

            st.push(c);

        }

        while(k > 0) {
            st.pop();
            k--;
        }

        while(!st.isEmpty()) {
            char curr = st.pop();
            result.append(curr);
        }

        result = result.reverse();
        int i = 0;

        char curr = result.charAt(i);

        while(i != result.length() - 1 && curr == '0') {
            i++;
            curr = result.charAt(i);
        }

        return result.substring(i, result.length()).toString();
    }
}



// Time Complexity : O(n) where n is number of tokens as each token is processed exactly once.
// Space Complexity : O(n) as stack may hold upto n tokens.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// The evalRPN function evaluates a Reverse Polish Notation (RPN) expression represented by the input array tokens. It uses a stack to store intermediate 
// results during the evaluation. As the algorithm iterates through tokens, it checks if the current token is an operator (+, -, *, or /). If it is, the top 
// two numbers are popped from the stack, the operation is performed, and the result is pushed back onto the stack. If the token is a number, it is directly 
// pushed onto the stack. At the end of the iteration, the final result of the RPN expression is the only value left in the stack, which is returned.

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String str: tokens) {
            int num2 = 0;
            int num1 = 0;
            int currResult = 0;

            if(str.equals("+")) {
                num2 = st.pop();
                num1 = st.pop();
                currResult = num1 + num2;
                st.push(currResult);
            } else if(str.equals("-")) {
                num2 = st.pop();
                num1 = st.pop();
                currResult = num1 - num2;
                st.push(currResult);
            } else if(str.equals("*")) {
                num2 = st.pop();
                num1 = st.pop();
                currResult = num1 * num2;
                st.push(currResult);
            } else if(str.equals("/")) {
                num2 = st.pop();
                num1 = st.pop();
                currResult = num1 / num2;
                st.push(currResult);
            } else {
                st.push(Integer.parseInt(str));
            }
        }

        if(!st.isEmpty()) {
            return st.pop();
        }

        return 0;
    }
}


