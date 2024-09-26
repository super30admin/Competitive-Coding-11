#Time Complexity : O(N)
#Space Complexity : O(N)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        count = 0
        for i in range(len(num)):
            while stack and int(num[i]) < int(stack[-1]) and count < k:
                stack.pop()
                count +=1
            stack.append(int(num[i]))
        # here not less than equal to k
        while count < k:
            stack.pop()
            count +=1

        strr = ""
        li = list(stack)
        for i in range(len(li)):
            strr += str(li[i])
        
        if len(strr) == 0:
            return '0'
        #also converted all string to int then int to string instead of checkinh only first element as 0. There might be multiple starting zeroes
        strr = int(strr)
        strr = str(strr)
            
        return strr
            

            