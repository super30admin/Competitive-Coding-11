// Time Complexity :  O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we push numbers in to stack. if there is an operation character,
// we pop elements from stack and perform operation and push again.
// at last stack.top() will be the answer.


class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        int n = tokens.size();
        stack<int>st;
        int ans = 0;
        for(auto& s:tokens)
        {
            if(s=="/" || s=="*" || s=="+" || s=="-")
            {
                int b = st.top();st.pop();
                int a = st.top();st.pop();
                if(s=="+") ans = a+b;
                else if(s == "-") ans = a-b;
                else if(s=="*") ans = a*b;
                else ans = a/b;
                st.push(ans);
            }
            else
            {
                int num = stoi(s);
                st.push(num);
            }
        }
        return st.top();
    }
};