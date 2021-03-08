#time: O(n)
#space: O(n)

import math
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack=[]
        op=["+", "-", "*","/"]
        vset=set(op)
        
        
        for i in tokens:
            
            if i not in vset:
                stack.append(int(i))
            else:
                b=stack.pop()
                a=stack.pop()
                if(i=="+"):
                    stack.append(a+b)
                elif(i=="-"):
                    stack.append(a-b)
                elif(i=="*"):
                    stack.append(a*b)
                elif(i=="/"):
                    d=a/b
                    if(d>0):
                        stack.append(a//b)
                    else:
                        stack.append(math.ceil(a/b))
                        
        return stack[-1]
            