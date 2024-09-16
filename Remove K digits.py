# Time:- O(n)
# Space:- O(n)
# Approach:- The key observation here is that if a number= D1D2D3D4 if D1>D2 then if we remove D1 then we can form a number which is the smallest possible by removing a digit from the number. Using this observation we use a stack to store the numbers and keep removing the number according to this observation. Edge case:- 12345 if we had to remove 1 number to make the minimal possible number we 
# should remove 5 to get 1234 and this is what we will do when we cant remove k numbers from the number
# given
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        digit_stack=[]
        for i in num:
            while k and digit_stack and i<digit_stack[-1] :
                digit_stack.pop()
                k-=1
            digit_stack.append(i)
        # Edge case
        if k>0:
            number="".join(digit_stack[:len(digit_stack)-k])
            if number=="":
                return "0"
            return str(int(number))
        return str(int("".join(digit_stack)))