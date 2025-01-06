
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        # Initialize a stack to store digits temporarily
        stack = []

        # Iterate through each character (digit) in the input string
        for c in num:
            # Remove digits from the stack if they are greater than the current digit `c`
            # and we still have `k` digits left to remove
            while k > 0 and stack and stack[-1] > c:
                k -= 1  # Decrease `k` because we removed a digit
                stack.pop()  # Remove the top digit from the stack

            # Add the current digit to the stack
            stack.append(c)

        # If there are still digits to remove after the loop, remove them from the end
        stack = stack[:len(stack) - k]

        # Convert the stack to a string and remove leading zeroes
        res = "".join(stack)
        # If the result is empty after removing zeroes, return "0"
        return str(int(res)) if res else "0"

