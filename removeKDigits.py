class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        # T: O(n), S: O(n)
        if k >= len(num):
            return "0"

        stack = []

        for n in num:
            while k > 0 and stack and stack[-1] > n:
                stack.pop()
                k -= 1
            stack.append(n)

        while k > 0:
            stack.pop()
            k -= 1

        res = "".join(stack).lstrip("0")
        return res if res else "0"
