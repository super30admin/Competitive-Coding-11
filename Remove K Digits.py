# TC : O(n)
# SC : O(n) - if the digits are increasing

class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        stack = []
        
        for ch in num:
            while stack and k>0 and ch<stack[-1]:
                stack.pop()
                k-=1
                
            stack.append(ch)
            
        if k >0:
            stack = stack[:len(stack)-k]
        res = "0"+"".join(stack)
        return str(int(res))