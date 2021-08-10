class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        """Time complexity-O(2n+k) as in worst case for one of the element need to pop all other elements
        Space complexity-O(n)"""
        arr=[]
        for i in range(len(num)):
            while arr and num[i]<arr[-1] and k>0:
                arr.pop()
                k-=1
            arr.append(num[i])
        for i in range(k):
            if arr:
                arr.pop()
        retstring = "".join(arr).lstrip('0')
        return retstring if retstring else "0"
                
                
        # arr=[]
        # for i in range(k):
        #     maxi=-99999999
        #     for j in range(len(num)):
        #         maxi=max(maxi, int(num[j]))
        #     index=num.index(str(maxi))
        #     if index!=len(num):
        #         num=num[:index]+num[index+1:]
        #     else:
        #         num=num[:index]
        # return num
                
                
                
            
        