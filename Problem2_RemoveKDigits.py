# Time Complexity: O(n), where n - length of the
# Space Complexity: O(n), stack

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []

        # Remove all greater leading digits
        for digit in num:
            while stack and k > 0 and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)

        # If k digits are not yet removed, remove the remaining from stack
        for i in range(k):
            stack.pop()

        # Return the digits from stack as a string and remove the leading zeroes
        result = "".join(stack).lstrip('0')

        if not result:
            return '0'

        return result
