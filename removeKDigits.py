#402. Remove K Digits
"""
Time Complexity : O(n)
Space Compelxity : O(n)
"""
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if len(num) <= k:
            return "0"
        
        stack = []
        count = 0
        for ch in num:
            #check for decreasing value
            while len(stack) != 0 and stack[-1] > ch and count != k:
                stack.pop()
                count += 1
            
            stack.append(ch)
        
        # if len(stack) >= len(num)-k means that someting is not popped out.
        #ideal len(stack) should be len(num) - k. So. we remove top elements
        #because they are max elements that are needed to be removed.
        if len(stack) >= len(num) - k:
            #print(len(stack) - (len(num) - k))
            for _ in range(0, len(stack) - (len(num) - k)):
                stack.pop()
        
        # remove 0s from begining of string
        return str(int("".join(stack)))
