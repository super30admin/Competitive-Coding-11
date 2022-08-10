# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        if num==None or len(num)==0: return "0"
        if len(num)==k: return "0"
        stack=[]
        res=''
        count=0
        for c in num:
            cur=int(c)
            while len(stack)!=0 and count!=k and cur<stack[-1]:
                stack.pop()
                count+=1
            stack.append(cur)
        while len(stack)!=0:
            if count!=k:
                stack.pop()
                count+=1
            else:
                res=str(stack.pop())+res
        return str(int(res))