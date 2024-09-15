'''
Solution:
1.  Maintain a monotonic stack where if the current number if lesser than top of the stack,
    pop the top element and decrement k and push each element no matter what to the stack.
2.  If k is still greater than 0 => pop till k == 0.
3.  Now combine all elements remaining in the stack and handle edge cases like removing leading 0s.

Time Complexity:    O(N)    |   Space Complexity:   O(N)
--- Passed all testcases successfully on leetcode.
'''


class Solution:
    
    def __removeLeadZeroes(self, string):
        
        #   function to remove leading 0s
        index = 0
        
        while (index < len(string)):
            if string[index] != '0':
                break
            index += 1
            
        return string[index : ]
            
    
    def removeKdigits(self, nums: str, k: int) -> str:
        
        #   Initializations
        stack = []
        
        #   add each element to the stack but maintain it to be a monotonous stack in ascending order
        for i in range(len(nums)):
            
            while (len(stack) > 0 and k > 0 and nums[i] < stack[-1]):
                stack.pop()
                k -= 1
                
            stack.append(nums[i])
        
        #   if k > 0, then pop those many elements    
        for i in range(k):
            stack.pop()
         
        #   make the final string   
        finalString = ''.join(stack)
         
        #   remove leading zeroes if any   
        finalString = self.__removeLeadZeroes(finalString)

        #   edge case check
        if (finalString == ''):
            return '0'
        
        #   return final string
        return finalString     
        