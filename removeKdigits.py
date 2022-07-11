'''
time complexity: O(n)
space complexity: O(n)
'''
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        #base case
        if len(num)==0 or k==0: return num
        
        #logic
        st = []
        #0 1 2 3 4 5
        #  !
        #st = 0 1 2  3 4 5  
        #k = 3
        for i in range(len(num)):
            #while codition poping elements
            while(len(st)>0 and k>0 and st[-1]>int(num[i])):
                st.pop()
                k-=1
                                
            #insert
            st.append(int(num[i]))

        #0 1 2 3 4 5 6
        #  !
        ans = ""
        #0 - 4
        print(st)
        print(len(st)-k)

        for i in range(0,len(st)-k):
            if(i==0 and st[i]==0):
                continue
            ans+=str(st[i])
            
            
        return str(int(ans)) if len(ans) > 0 else "0"