#Time Complexity : O(N)
#Space Complexity : O(N)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for i in num:
            while(k>0 and stack and stack[-1]>i):
                k-=1
                stack.pop()
            stack.append(i)
        #This handles leftover deletions when no digits were popped in the loop (typically in sorted-increasing input).
        if(k>0):
            stack = stack[:len(stack)-k]
        #To remove the initial 0's
        res = "".join(stack).lstrip("0")
        if res:
            return res
        else:
            return "0"




        