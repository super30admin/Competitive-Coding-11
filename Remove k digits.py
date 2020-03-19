# -*- coding: utf-8 -*-
"""
Created on Wed Mar 18 19:37:34 2020

@author: WELCOME
"""
"""
Remove K digits
Time - O(N)
Space - O(N)
"""

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        nums=num
        if k>len(nums):
            return " "
        stack=[]
        for i in range(len(nums)-1):
            stack.append(nums[i])
            while stack and int(nums[i+1])<int(stack[-1]) and k>0:
                stack.pop()
                k-=1
        if k==0:
            stack.append(num[-1])
        else:
            while stack and k>1:
                stack.pop()
                k-=1
        string=""
        string=string.join(stack)
        
        if string=="":
            return str(0)
        string=str(int(string))
        return string