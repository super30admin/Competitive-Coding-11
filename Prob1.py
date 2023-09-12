class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        #Brute Force - All possible combinations with backtracking -> Exponential TC
        #2 for loops - move from left to right, whenevr num[i]>num[i-1], remove num[i] adn start from i=0 again. Do this k time -> N^2 TC

        #3 Stack - move from left to right, whenevr st[-1]>n, pop the top of st and keep doing this till either k==0 or stack in empty.

        #Then, k might not be 0, in that case pop out top of the st.
        #Edge case - 10200,k=1. Answer should be 200, this method will give 0200. So strip leftmost 0s if they exist.

        st=[]
        for n in num:
            while st and k>0 and st[-1]>n:
                k-=1
                st.pop()
            st.append(n)
        for i in range(k): # k might not be 0, in that case pop out top of the st.
            st.pop()
        res=''.join(st).lstrip('0') #Edge case - 10200,k=1. Answer should be 200, this method will give 0200. So strip leftmost 0s if they exist.
        return res if res else '0'
        
        
        
        
        
        
        