# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
#
class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        stack = []
        dictu = {'+', '-', '*', '/'}
        for i in tokens:
            if i in dictu:
                if i == '+':
                    a = stack.pop()
                    b = stack.pop()
                    stack.append(a+b)
                elif i == '-':
                    b = stack.pop()
                    a = stack.pop()
                    stack.append(a-b)
                elif i == '*':
                    a = stack.pop()
                    b = stack.pop()
                    stack.append(a*b)
                else:
                    a = stack.pop()
                    b = stack.pop()
                    stack.append(int(b/a))
            else:
                stack.append(int(i))
        return stack[-1]


print(Solution().evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]))
