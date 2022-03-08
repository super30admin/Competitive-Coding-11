

"""
time: O(N)
space: O(N)
"""

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = list()
     
        

        
        #"1432219"
        
        for n in num:

            #logic
            while stack and k and n < stack[-1]:
                stack.pop()
                k -= 1

                
                
            if stack or n is not "0":
                stack.append(n)
                
        if k: # not fully spent
            stack = stack[0:-k]

 
                
        return ''.join(stack) or "0"