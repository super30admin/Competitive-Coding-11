# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for value in num:
            while k > 0 and stack and stack[-1] > value:
                k -= 1
                stack.pop()
            stack.append(value)

        stack = stack[:len(stack) - k]
        result = "".join(stack)
        return result.lstrip("0") or "0"