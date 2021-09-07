#TC:O(n)
#Sc:O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        n = len(tokens)
        if n<=1:
            return tokens[0]
        stack = []
        stack.append(int(tokens[0]))
        stack.append(int(tokens[1]))
        print(stack)
        for data in tokens[2:]:
            try:
                # print(data)
                val = int(data)
                stack.append(val)
            except ValueError:
                # print(stack)
                if stack:
                    right = stack.pop()
                    left = stack.pop()
                    if data == "*":
                        val = left*right
                    if data == "+":
                        val = left+right
                    if data == "-":
                        val = left-right
                    if data == "/":
                        val = int(left/right)
                    stack.append(val)
        return stack.pop()
            