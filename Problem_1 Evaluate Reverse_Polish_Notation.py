# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token not in "+-*/":
                #If number is found, Append it to stack
                stack.append(int(token))
                continue
            #Pop the first 2 numbers from stack and perform the operation
            num2 = stack.pop()
            num1 = stack.pop()

            result = 0
            if token == '+':
                result = num1 + num2
            elif token == '-':
                result = num1 - num2
            elif token == '*':
                result = num1 * num2
            else:
                result = int(num1 / num2)
            stack.append(result)

        return stack.pop()