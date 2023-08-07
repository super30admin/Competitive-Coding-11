# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        sys.set_int_max_str_digits(pow(10,5))
        if(k>=len(num)):
            return "0"
        stack =[]
        for i in num:
            while k >0 and stack and stack[-1]>i:
                k-=1
                stack.pop()
            stack.append(i)
        stack=stack[:len(stack)-k]
        res="".join(stack)
        return str(int(res))
        