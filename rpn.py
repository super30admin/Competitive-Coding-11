# TC===>O(n)
# SC==>O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack=[]
        
        def findNum(n):
            try:
                int(n)
                return True
            except:
                return False
            
            
        for i in tokens:
            if findNum(i):
                stack.append(i)
            else:
                num1=int(stack.pop())
                num2=int(stack.pop())
                
                if i=="+":
                    res=num2+num1
                    
                elif i=="*":
                    res=num2*num1
                elif i=="-":
                    res=num2-num1
                    
                elif i=="/":
                    res=int(num2/num1)
                stack.append(str(res))
                
        return stack[-1]