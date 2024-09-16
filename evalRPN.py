# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        l = ['+','-','*','/']
        for token in tokens:
            if token not in l:
                stack.append(int(token))
                continue
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
