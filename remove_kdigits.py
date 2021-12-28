# TC==>O(n)
# SC==>O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack=[]
        s=k
        for i in num:
            while stack and s and stack[-1]>i:
                stack.pop()
                s=s-1
            stack.append(i)
        res="".join(stack[0:len(num)-k]).lstrip("0")
        if len(res):
            return res
        else:
            return "0"