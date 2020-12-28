#Time Complexity : O(n) where n is length of number
#Space Complexity : O(n) where n is length of number
#Did this code successfully run on Leetcode : Yes

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []

        for digit in num:
            while k and stack and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)

        #if we still have digits to remove remove the top k digits
        while k:
            stack.pop()
            k -= 1

        # trip the leading zeros
        return "".join(stack).lstrip('0') or "0"
