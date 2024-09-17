# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        result = ""
        for i in range(len(num)):
            while len(stack)!=0 and num[stack[-1]]>num[i] and k!=0:
                k -=1
                stack.pop()
            stack.append(i)
        while k!=0:
            stack.pop()
            k -=1
        for i in range(len(stack)):
            if num[stack[i]]=='0' and result =="":
                continue
            result +=num[stack[i]]
        if result == "":
            return "0"
        else:
            return result
        