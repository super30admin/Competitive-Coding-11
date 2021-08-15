# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        if len(num)==k:
            return '0'
        for i in num:
            while stack and k and stack[-1]>i:
                stack.pop()
                k-=1
            stack.append(i)
            
        while k:
            stack.pop()
            k -= 1
        #To Truncate the leading 0's
        return "".join(stack).lstrip('0') or "0" 

