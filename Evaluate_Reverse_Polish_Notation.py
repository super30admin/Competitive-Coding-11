# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using stack. Iterate over the tokens list and check if the element is digit or operator
# If it is opertor then pop the 2 recent elements and perform the operation and append the res to stack
# Else if it is number then append it to stack
# Return the top element of stack

class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        stack = []
        for i in range(len(tokens)):
            if tokens[i] in ["+", "-", "*", "/"]:
                num1 = stack.pop()
                num2 = stack.pop()
                if tokens[i] == "+":
                    res = num1 + num2
                elif tokens[i] == "-":
                    res = num2 - num1
                elif tokens[i] == "*":
                    res = num1 * num2
                else:
                    res = int(num2/num1)
                stack.append(res)
            else:
                stack.append(int(tokens[i]))
        return stack[-1]