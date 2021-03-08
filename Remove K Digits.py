#time: O(n)
#space: O(n)

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack=[]
        for i in num:
            while(stack!=[] and i<stack[-1] and k>0):
                stack.pop()
                k-=1
            stack.append(i)
        for i in range(k):
            stack.pop()
        result="".join(stack).lstrip("0")
        if(result==""):
            return "0"
        else:
            return result
            