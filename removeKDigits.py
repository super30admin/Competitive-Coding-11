class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for n in num:
            n = ord(n) - ord('0')
            while stack and k > 0 and stack[-1] > n:
                stack.pop()
                k -= 1
            if not stack  and n == 0:
                continue
            stack.append(n)

        while stack and k > 0:
            stack.pop()
            k -= 1
        res = []
        for i in stack:
            res.append(str(i))
        if not res:
            return "0"
        return "".join(res)