# TimeComplexity:O(n)
# SpaceComplexity:O(n)
# Apprach:
# BF:try all possible combiantions adn get min out of those , 
# optimal: we know lesser index vals contribute more than ones at last but should we remove first k digits ? No we need to remove whcih contribute more



class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        st=[]
        # Input: num = "1432219", k = 3
        st=[num[0]]
        for i in range(1,len(num)):
            """
            "1234"
            st=[1,2,0,0]
            """
            if k>0:
                while(len(st) and int(num[i])<int(st[-1]) and k>0):
                    st.pop()
                    k-=1
                st.append(num[i])
            else:
                st.append(num[i])
        while(len(st) and k>0):
            #1234
            st.pop()
            k-=1
        #0200
        while(len(st) and st[0]=="0" ):
            st.pop(0)
        if len(st)==0:return "0"
        return "".join(st)


        
