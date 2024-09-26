# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using stack. Iterate over the tokens list and check if the element is digit or operator
# If it is opertor then pop the 2 recent elements and perform the operation and append the res to stack
# Else if it is number then append to stack
# Return the top element of stack


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if not tokens:
            return None
        stack = []
        for i in tokens:
            if i in "+-*/":
                a = stack.pop()
                b = stack.pop()
                if i == "+":
                    stack.append(a + b)
                elif i == "-":
                    stack.append(b - a)
                elif i == "*":
                    stack.append(a * b)
                elif i == "/":
                    stack.append(int(b / a))
            else:
                stack.append(int(i))
        return stack[-1]