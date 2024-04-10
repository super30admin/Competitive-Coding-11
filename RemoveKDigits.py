'''
TC: O(n) - through every digit in the input
SC: O(n) - stack space
'''
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        flag = True
        for v in num:
            while stack and stack[-1] > v and k:
                stack.pop()
                k -= 1
            stack.append(v)
        stack = stack[:-k] if k else stack
        if not stack:
            return "0"
        res = "".join(stack).lstrip('0')
        return res if res else "0"
s = Solution()
print(s.removeKdigits("1432219"))
print(s.removeKdigits("10200"))
print(s.removeKdigits("10"))
print(s.removeKdigits("9"))
print(s.removeKdigits("1111111"))
print(s.removeKdigits("112"))
print(s.removeKdigits("10"))