# Time complexity : O(n)
# Space complexity : O(n)
# Using monostack (increasing) to find the smallest number

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        st = []
        
        # traverse over all the digits in the num list
        for digit in num:
          
           # while we have a value of k, stack is not empty and top of stack has value greater than the incoming digit
            while k and st and st[-1] > digit:
                # pop the stack, and decrement k, this is the digit that needs to be removed
                st.pop()
                k -= 1
            # append the current digit to the stack
            st.append(digit)
        #print(st, k)
        
        # after traversing, if k is not zero then pop the stack until k = 0
        if k != 0:
            while k != 0:
                st.pop()
                k -= 1
        
        # join the stack as string and remove the leading 0's or else return 0
        return "".join(st).lstrip('0') or "0"
