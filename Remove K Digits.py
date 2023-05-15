# Time Complexity :  O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if len(num) == k:
            return "0"
        stack = []
        c = 0
        for digit in num:
            while len(stack) > 0 and stack[-1] > digit and k:
                stack.pop()
                k-=1
            stack.append(digit)
        result = ""
        if k > 0:
            stack = stack[:-k]
        return "".join(stack).lstrip('0') or "0"
            
 