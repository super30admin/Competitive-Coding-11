class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack=[]
        if len(num)<2:
            return '0'
        for val in num:         
            while stack and k>0 and stack[-1]>val:
                stack.pop()
                k-=1
            stack.append(val)
        
        stack=stack[:-k] if k else stack
        res=''.join(stack).lstrip('0')
        return res if len(res)>0 else '0'

