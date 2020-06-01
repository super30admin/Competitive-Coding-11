"""
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        """
        Idea (resemblence the idea of removing duplicate letters)
        - Stk at the end of processing contains those integers which have lower value than other digits in the string
        - Handle the trailing 0s and advance the stack pointer(by popping the elements) until no 0.
        
        """
        size = len(num)
        if k >= size:
            return "0"
        stk = []
        count = 0
        while count < size:
            while k > 0 and stk and stk[-1] > num[count]:
                k-=1
                stk.pop()
            stk.append(num[count])
            count+=1
        
        #in case of sorted number(k won't decrease at all in above stack condition loop)
        while k > 0:
            #pop the element linearly, because it's ensured tht those will be higher elements
            stk.pop()
            k-=1
        
        i = 0
        #remove leading 0s 
        while stk and stk[i] == '0':
            stk.pop(0)
        
        #base case - handling case of trailing 0(stack will be empty)
        if not stk:
            return "0"
        
        return "".join(stk)