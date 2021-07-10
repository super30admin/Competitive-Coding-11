"""402. Remove K Digits
TC - O(n)
SC - O(n)"""
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        
        for n in num:
            while stack and k>0 and stack[-1]>n:
                k -= 1
                stack.pop()
            stack.append(n)
        
        if k > 0:
            stack = stack[:-k]
        return ''.join(stack).lstrip('0') or'0'
            