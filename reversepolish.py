# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operators=['+','-','*','/']
        stack = []
        for val in tokens:
            if val not in operators:
                stack.append(int(val))
            elif val == '+':
                b=stack.pop()
                a=stack.pop()
                stack.append(a+b)
            elif val == '-':
                b=stack.pop()
                a=stack.pop()
                stack.append(a-b)
            elif val == '*':
                b=stack.pop()
                a=stack.pop()
                stack.append(a * b)
            elif val == '/':
                b=stack.pop()
                a=stack.pop()
                stack.append(int(a/b))
        return stack[0]




