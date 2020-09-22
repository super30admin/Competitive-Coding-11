# Leetcode 402. Remove K Digits

# Time Complexity :  O(n) where n is the size of the string

# Space Complexity : O(n) where n is the size of the stack

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Add the digits in the number to stack as long as they are in increasing order. If the digit 
# is lesser than the previous entry pop the stack and decrement k and append digit to the stack. If k is 
# not zero remove the remainig k elements from the end. Remove leading zeroes and return result if its 
# length is greater than zero. else return "0".

# Your code here along with comments explaining your approach

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if not num or len(num) == 0:
            return "0"
        stack = []
        # Add the digits in the number to stack as long as they are in increasing order
        for digit in num:
            # if the digit is lesser than the previous entry pop the stack and decrement k
            while stack and k and int(stack[-1])>int(digit):
                stack.pop()
                k -= 1
            # append digit to the stack    
            stack.append(digit)
        
        # if k is not zero remove the remainig k elements from the end
        if k:
            for i in range(k):
                stack.pop()
        
        result = "".join(stack)
        
        # removing leading zeroes
        idx = 0
        for i in range(idx,len(result)):
            if result[idx] == "0":
                idx += 1
        result = result[idx:]  
        if len(result) == 0:
            return "0"
        else:
            return result