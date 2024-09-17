'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Add elements into stack, Whenever you see the first drop ie if we have numbers 3,4,1 there is a drop
from 4->1 then pop elements k times until the stack has elements smaller than the current element or k is 0. these
popped elements are the digits to be removed

Edge cases:
If we have 00200 then we need remove the front 00's to get 200 so remove the front 0's and output 200, if output is ""
ie we removed all the characters then output 0
'''


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if num == None or k == None:
            return "0"

        if k >= len(num):
            return "0"

        stack = []
        for digit in num:
            while k and stack and stack[-1] > digit:
                stack.pop()
                k -= 1

            stack.append(digit)

        if k:
            stack = stack[:-k]

        i = 0

        if len(stack) > 1:
            while i < len(stack) and stack[i] == '0':
                i = i + 1

        # All 0's only in output
        if i == len(stack):
            return "0"
        else:
            return ''.join(stack[i:])
