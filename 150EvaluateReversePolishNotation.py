# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        for token in tokens:

            if token == '+':
                value2 = stack.pop()
                value1 = stack.pop()
                stack.append(value1 + value2)
            elif token == '-':
                value2 = stack.pop()
                value1 = stack.pop()
                stack.append(value1 - value2)
            elif token == '*':
                value2 = stack.pop()
                value1 = stack.pop()
                stack.append(value1*value2)
            elif token == '/':
                value2 = stack.pop()
                value1 = stack.pop()
                stack.append(int(value1/value2))
            else:
                stack.append(int(token))

        return stack[0]