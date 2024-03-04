# Time Complexity: O(N)
# Space Complexity: O(N)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        ops = ["-", "+", "*", "/"]
        stack = []

        for token in tokens:
            if token in ops:
                right = stack.pop()
                left = stack.pop()
                if token == "+":
                    res = left + right
                elif token == "-":
                    res = left - right
                elif token == "*":
                    res = left * right
                elif token == "/":
                    res = left / right
                stack.append(int(res))
            else:
                stack.append(int(token))
        
        return int(stack[0])

        
