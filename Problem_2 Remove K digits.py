# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if num == None or len(num) == 0:
            return ""
        stack = []
        for digit in num:
            while k and stack and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)
        #If there are still digits left to remove
        while k:
            stack.pop()
            k -= 1
        #To Truncate the leading 0's
        return "".join(stack).lstrip('0') or "0"