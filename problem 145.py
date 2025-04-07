# https://leetcode.com/problems/remove-k-digits/

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:

        if k == len(num):
            return "0"

        stack = []
        for i in range(len(num)):
            while stack and int(num[i]) < stack[-1] and k > 0:
                stack.pop()
                k-=1
            stack.append(int(num[i]))

        while stack and k!=0:
            stack.pop()
            k-=1

        
        res = []
        while stack:
            res.append(str(stack.pop()))
        
        for i in range(len(res)-1, -1, -1):
            if res[i] != '0':
                break
            res.pop()
        
        if len(res) == 0:
            return "0"
        
        res.reverse()


        ans = "".join(res)

        return ans
            
# TC: O(n)    
# SC: O(n)