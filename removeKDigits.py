#Time: O(2n + k)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for digit in num: 
            while stack and k > 0 and stack[-1] > digit:
                k += -1
                stack.pop()
            stack.append(digit)
        
        for i in range(k):
            stack.pop()
        
        ret = ''.join(stack).lstrip('0')

        if not ret:
            return '0'

        return ret