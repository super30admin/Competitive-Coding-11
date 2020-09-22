# Leetcode 150. Evaluate Reverse Polish Notation

# Time Complexity :  O(n) where n is the size of the array

# Space Complexity : O(n) where n is the size of the stack

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Add the numbers to stack, when a operator is found pop the last two numbers from the stack,
# evaluate the operation and add the result back into stack. Once all the tokens in the input are evaluate
# pop the stack for the final result.

# Your code here along with comments explaining your approach

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if not tokens or len(tokens) == 0:
            return 0
        stack = []
        ops = {'+','-','*','/'}
        num1 = None
        num2 = None
        # res = 0
        for token in tokens:
            if token in ops:
                num2 = stack.pop()
                num1 = stack.pop()
                if token == '+':
                    res = num1 + num2
                if token == '-':
                    res = num1 - num2
                if token == '*':
                    res = num1 * num2
                if token == '/':
                    res = int(num1 / num2)
                stack.append(res)
            else:
                stack.append(int(token))
            print(len(stack))
        return stack.pop()