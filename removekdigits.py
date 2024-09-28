#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        n = len(num)
        i = 0
        count = 0
        while i<=n-1: 
            while stack and k>0 and stack[-1]>num[i]:
                stack.pop()
                k-= 1
            
            stack.append(num[i])
            i+=1
        if k>0:
            stack = stack[:len(stack)-k]
        res = "".join(stack)
        return str(int(res)) if res else "0"
        