// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public:
        int evalRPN(vector<string>& tokens) {
            int n = tokens.size();
            stack<int> st;
            int ans = 0;
            for(auto i:tokens){
                if(!st.empty() && (i == "+" || i == "-" || i == "*" || i == "/")){
                    int a = st.top(); st.pop();
                    int b = st.top(); st.pop();
                    if(i == "+"){
                        st.push(a+b);
                    }
                    else if(i == "-"){
                        st.push(b-a);
                    }
                    else if(i == "*"){
                        st.push(a*b);
                    }
                    else{
                        st.push(b/a);
                    }
                }
                else{
                    st.push(stoi(i));
                }
            }
            return st.top();
        }
    };