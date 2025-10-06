# Remove k digits
# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for n in num:
            # If the current digit is smaller than the last digit in the stack, remove the last digit. This approach works because if the left digit is larger, removing it will lead to a smaller number.
            while k and stack and stack[-1]>n:
                stack.pop()
                k-=1 # Decrease k as we have removed a digit
            stack.append(n)
        # If k is still not zero, remove the leftmost digits which is at the end of the stack
        if k!=0:
            stack = stack[:-k]
        return "".join(stack).lstrip('0') or "0" # Remove leading zeros and return "0" if the result is empty


        