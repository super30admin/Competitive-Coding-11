# Approach: Use Stack, monotonically increasing, greedy method
# TC: O(n) where n is len of string
# SC: O(n) where we may have up to n elements in the stack
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        
        for n in num:
             # if the incoming element is less than the top element in stack
             # then pop the stack and reduce the count
            while stack and k and stack[-1]>n:
                stack.pop()
                k-=1 
            stack.append(n)
        #if the count > 0 : we will pop last count number of elements from the top of the stack
        ans=  ''.join(stack[:-k] if k else stack)
        return str(int(ans)) if len(ans)>0 else '0'