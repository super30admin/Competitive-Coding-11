
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if not tokens:
            return 0
        
        stack = []
        
        for i in tokens:
            #print(stack)
            if i not in "+-*/":
                stack.append(int(i))
                continue
            a = stack.pop()
            b = stack.pop()
            result = 0
            if i == "*":
                result = a*b
            elif i == "/":
                result = int(b/a)
            elif i == "+":
                result = b+a
            elif i == "-":
                result = b-a
            
            stack.append(result)
        
        
        return stack.pop()
                
                
            
        
                
                
