class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(n)
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for n in num:
            while stack and k and int(stack[-1]) > int(n):
                stack.pop()
                k -= 1

            stack.append(str(n))

        while k:
            stack.pop()
            k -= 1

        i = 0
        while i < len(stack) and stack[i] == '0':
            i += 1

        return "".join(stack[i:]) if len(stack[i:]) > 0 else "0"