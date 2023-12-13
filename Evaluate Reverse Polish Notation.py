# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        for i in range(len(tokens)):
            if tokens[i] == "+":
                a = stack.pop()
                b = stack.pop()
                stack.append(a+b)
            elif tokens[i] == "-":
                a = stack.pop()
                b = stack.pop()
                stack.append(b-a)
            elif tokens[i] == "/":
                a = stack.pop()
                b = stack.pop()
                print(b,a)
                stack.append(int(b/a))
            elif tokens[i] == "*":
                a = stack.pop()
                b = stack.pop()
                stack.append(a*b)
            else:
                stack.append(int(tokens[i]))
            
        return stack[0]