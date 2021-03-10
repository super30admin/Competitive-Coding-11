        st=[]
        for i in num:
            while len(st)>0 and k>0 and st[-1]>i:
                k-=1
                st.pop()
            st.append(i)
            
        for i in range(k):
            st.pop()
        
        retstring=''.join(st).lstrip('0')
                       
        if not retstring:
            return '0'
        return retstring     
