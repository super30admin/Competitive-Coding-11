#Time -> O(n)
#Space -> O(n)

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack=[]
        
        #Iterate and if the elemnt is greater then pop the previous elemnt
        #Then add it to the stack
        for i in num:
            while k >0 and stack and stack[-1]>i:
                k-=1
                stack.pop()
            
            stack.append(i)
            
        #now if the number is in increasing order then there might be lements in the stack
        while stack and k>0:
            k-=1
            stack.pop()

        #Edge case 
        if not stack:
            return "0"
        
        #Join the result and convert it to string to give the o/P
        return str(int("".join(stack)))