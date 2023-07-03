// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :



// Your code here along with comments explaining your approach


class Solution {
public:
    string removeKdigits(string num, int k) {
        int n = num.size();
        stack<char>st;
        st.push(num[0]);
        int i = 0;
        for(i=1;i<n;i++)
        {
            while(!st.empty() &&(k>0)&& ( st.top()>num[i]))
            {
                st.pop();
                k--;
            }
            st.push(num[i]);
        }
        while(k--)
        {
            st.pop();
        }
        
        vector<char>v; 
        while(!st.empty())
        {
            v.push_back(st.top());
            st.pop();
        }
        int m = v.size();
        for(int i = m-1;i>=0;i--)
        {
            if(v[i]=='0') {
                v.pop_back();
            }
            else break;
        }
        m = v.size();
        string s(m,'a');
        for(int i = 0;i<m;i++)
        {
            s[i] = v[m-1-i];
        }
        
        return (s=="")?"0":s;
       
    }
};