# Time Complexity: O(n+k) = O(n)
# Space Complexity: O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for i in num:
            while k and stack and stack[-1] > i: # Runs k times at max throughout irrespective of i
                stack.pop()
                k -= 1
            stack.append(i)
        ans = stack[:-k] if k else stack
        return "".join(ans).lstrip('0') or "0"