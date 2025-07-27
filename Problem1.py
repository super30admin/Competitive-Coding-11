"""
I used a stack to build the smallest possible number by removing digits. While iterating, I removed the top of the stack if the current digit was smaller and k > 0. After the loop, if k was still greater than 0, I popped remaining digits from the end.Finally, I joined the stack into a string and removed leading zeros. If the result was empty, I returned "0".
Time Complexity: O(n)
Space Complexity: O(n)
"""
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for digit in num:
            while stack and k > 0 and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)

        while k > 0:
            stack.pop()
            k -= 1
        result = ''.join(stack).lstrip('0')
        if result:
            return result
        else:
            return "0"