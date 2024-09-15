# -*- coding: utf-8 -*-
"""
Created on Wed Mar 18 19:36:56 2020

@author: WELCOME
"""
"""
Time - O(N)
Space - O(N)
"""

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack=[]
        operations={
            "+": lambda a,b:a+b,
            "-": lambda a,b:a-b,
            "*": lambda a,b:a*b,
            "/": lambda a,b: int(a/b)
        }
        for i in tokens:
            if i not in operations:
                stack.append(int(i))
            else:
                val1=stack.pop()
                val2=stack.pop()
                operator=operations[i]
                stack.append(operator(val2,val1))
                
        return stack[-1]
                