//Time - O(n)
//Space - O(n)

class Solution {
public:
    int evalRPN(vector<string>& vals) {
        if(vals.size() == 0) return 0;
        stack<int> st;
        unordered_set<string> uset({"-","+","/","*"});
        for(int i=0;i<vals.size();i++){
            if(uset.find(vals[i]) == uset.end()){
                st.push(stoi(vals[i]));
            }else{
                int a = st.top();st.pop();
                int b = st.top();st.pop();
                switch(vals[i][0]){
                    case '+':
                        st.push(a+b);
                        break;
                    case '-':
                        st.push(b-a);
                        break;
                    case '/':
                        st.push(b/a);
                        break;
                    case '*':
                        st.push(a*b);
                        break;
                }
            }
        }
        
        return st.top();
    }
};