# Time Complexity : O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for n in num:
            while k > 0 and len(stack) > 0 and stack[-1] > n:
                k -= 1 
                stack.pop()
            stack.append(n)
            # print(stack)
        if k > 0 :# eg. if all numbers are in increasing order 
            stack = stack[:-k]
        
        return ''.join(stack).lstrip('0') or '0'

if __name__ == "__main__":
    s = Solution()
    
    # Test case 1
    res = s.removeKdigits("1432219", 3)
    assert res == "1219"