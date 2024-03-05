//TC : O(N)
//SC : O(N)

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int>st;
        int result = 0;

        unordered_map<string, function<int (int,int)> >mp{
            {"+" , [](int a, int b) {return a+b;}},
            {"-" , [](int a, int b) {return a-b;}},
            {"*" , [](int a, int b) {return a*b;}},
            {"/" , [](int a, int b) {return a/b;}}
        };

        for(string &token : tokens){
            if(token == "+" || token == "-" || token == "*" || token == "/"){
                 int b = st.top();
                 st.pop();

                 int a = st.top();
                 st.pop();

                 result = mp[token](a,b);
                 st.push(result);
            }
            else{
                st.push(stoi(token));
            }
        }

        return st.top();
    }
};