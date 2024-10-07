class Solution:
    def evalRPN(self, tokens: List[str]) -> int:

        res = 0
        n = len(tokens)
        stack = []
        operand = ["+", "-", "/", "*"]
        for i in range(n):
            if tokens[i] not in operand:
                stack.append(int(tokens[i]))    
            elif tokens[i] in operand:
                op = tokens[i]
                a = stack.pop()
                b = stack.pop()

                if(op == "+"):
                    stack.append(a + b)
                elif(op == "*"):
                    stack.append(a * b)
                elif(op == "/"):
                #    if (b < 0 and a > 0 or a < 0 and b > 0):
                 #       absDiv = abs(b) // abs(a)
                  #      ret = -1 * absDiv
                   #     stack.append(ret)
                   # else:
                    stack.append(int(b / a))

                elif(op == "-"):
                    stack.append(b - a)
        
        return stack[-1]
                
                
### T(C) -- O(n)

### S(C) -- O(n)
            
            

        
