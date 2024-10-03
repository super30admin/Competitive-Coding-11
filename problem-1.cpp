/*
**Time Complexity (TC):** O(N)

**Space Complexity (SC):** O(N)

Where:
- `N` is the number of tokens in the input vector.
*/

class Solution {
public:
    int evalRPN(vector<string>& token) {
        stack<int> st;
        for(int i = 0; i < token.size(); i++){
            if(token[i] == "+"){
                int a = st.top();
                st.pop();
                int b = st.top();
                st.pop();
                a = a + b;
                st.push(a);
            }else if(token[i] == "-"){
                int a = st.top();
                st.pop();
                int b = st.top();
                st.pop();
                a = b - a;
                st.push(a);
            }else if(token[i] == "*"){
                int a = st.top();
                st.pop();
                int b = st.top();
                st.pop();
                a = a * b;
                st.push(a);
            }else if(token[i] == "/"){
                int a = st.top();
                st.pop();
                int b = st.top();
                st.pop();
                a = b / a;
                st.push(a);
            }
            else{
                st.push(stoi(token[i]));
            }
        }
        return st.top();
    }
};