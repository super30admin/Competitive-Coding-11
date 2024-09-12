class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if not num:
            return ""
        
        stack = []
        for i in range(len(num)):
            
            while stack and num[i] < stack[-1] and k >0:
                stack.pop()
                k -=1
            stack.append(num[i])
        
        if k:
            stack = stack[:-k]
        
        
        return "".join(stack).lstrip('0') or "0"
        
        
        
            
            
        
