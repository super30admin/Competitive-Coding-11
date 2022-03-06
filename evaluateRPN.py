#O(n) time and O(n) space solution
#n - number of characters / items in string and for space, height of the stack
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for character in tokens:
            if character == "+":
                stack.append(stack.pop() + stack.pop())
            elif character == "-":
                a, b = stack.pop(), stack.pop()
                stack.append(b - a)
            elif character == "/":
                a, b = stack.pop(), stack.pop()
                stack.append(int(b / a))
                
            elif character == "*":
                stack.append(stack.pop() * stack.pop())
            else:
                stack.append(int(character))
        
        return stack[0]

