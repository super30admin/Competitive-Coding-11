# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for i in range(len(tokens)):
            if tokens[i] == '+' or tokens[i] == '-' or tokens[i] == '*' or tokens[i] == '/':
                operand2 = stack.pop()
                operand1 = stack.pop()
                if tokens[i] == '+':
                    stack.append(operand1+operand2)
                elif tokens[i] == '-':
                    stack.append(operand1-operand2)
                elif tokens[i] == '*':
                    stack.append(operand1*operand2)
                elif tokens[i] == '/':
                    stack.append(int(operand1/operand2))
            else:
                stack.append(int(tokens[i]))
                
        return stack[-1]