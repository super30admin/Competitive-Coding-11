# Time Complexity : O(N) where N is length of the string to be evaluated
# Space Complexity : O(N) where N is length of the string to be evaluated
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        for token in tokens:
            if token == "+":
                num1 = stack.pop()
                num2 = stack.pop()
                stack.append(num2 + num1)
            elif token == "-":
                num1 = stack.pop()
                num2 = stack.pop()
                stack.append(num2 - num1)
            elif token == "*":
                num1 = stack.pop()
                num2 = stack.pop()
                stack.append(num2 * num1)
            elif token == "/":
                num1 = stack.pop()
                num2 = stack.pop()
                stack.append(int(num2 / num1))
            else:
                stack.append(int(token))
           
        return stack.pop()
                