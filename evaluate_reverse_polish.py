# Time Complexity: O(n)
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if not len(tokens):
            return 0
        stack = []
        for item in tokens:
            if item == "+":
                stack.append(stack.pop() + stack.pop())
            
            elif item == "-":
                first = stack.pop()
                second = stack.pop()
                stack.append(second - first)
            
            elif item == "*":
                first = stack.pop()
                second = stack.pop()
                stack.append(second * first)
            
            elif item == "/":
                first = stack.pop()
                second = stack.pop()
                stack.append(int(second / first))
                
            else:
                stack.append(int(item))
        return stack[0]