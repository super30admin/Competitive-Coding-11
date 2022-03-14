# sc & tc O(N)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack  = []
        
        i = 0
        while i < len(num):
            curr = num[i]
            if len(stack) == 0:
                stack.append(curr)
                i = i + 1
                
            elif stack[-1] <= curr or (k==0):
                stack.append(curr)
                i = i + 1
                
            elif stack[-1] > curr:
                k = k - 1
                _ = stack.pop()
            
        if k > 0:
            while (k):
                k = k - 1
                stack.pop()
                
        res = ""
        while (len(stack) and stack[0] == "0"):
            _= stack.pop(0)
            
        for e in stack:
            res += str(e)
            
        if res == "":
            return "0"
        
        return res
            
        
