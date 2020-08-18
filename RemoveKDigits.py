--------------------------remove k digits------------------------------------------
# Time Complexity : O(2**nXn) as N is length of string 
# Space Complexity : O(2**n)  as we are using set
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# We will iterate through string and check if the i+1 digit is less than the previous digit, then we will pop from te stack to remove 
# that element and decrement k , we will do so untill our k >0. If our string is iterated or our k is 0 we will return the remaining string from stack
# else we will iterate again and remove top k elements from stack.


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if not num or not k:
            return num
        
        stack = []
        for ch in num:
            while k>0 and len(stack)>0 and stack[-1]>ch:
                stack.pop()
                k -=1
            
            stack.append(ch)
        
        while k>0:
            stack.pop()
            k -=1
        
        return "".join(stack).lstrip('0') or "0"
            