# Time Complexity : O(n)
# Space Complexity : O(n) for the stack
# The code ran on LeetCode

# Maintain a monotonically increasing stack. Pop the top element from the stack if the incoming element is smaller the element at the top of the stack. If k is > 0 , remove elements from the stack until k == 0. Pop the elements from the stack, store them in result and remove left trailing zeroes.
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        stack = []

        for n in num:
            while k > 0 and stack != [] and stack[-1] > int(n):
                stack.pop()
                k-=1
            stack.append(int(n))

        for i in range(k):
            if stack:
                stack.pop()

        res = ''
        while stack:
            res += str(stack.pop())
        res = res[::-1]
        res = res.lstrip('0')

        return '0' if res =='' else res