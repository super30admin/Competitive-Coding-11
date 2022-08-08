//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        
        stack<int> st;
        for(int i=0;i<tokens.size();i++){
            if(tokens[i]=="+" || tokens[i]=="-" || tokens[i]=="*" || tokens[i]=="/"){
                int num1=st.top();st.pop();
                int num2=st.top();st.pop();
                if(tokens[i]=="+"){
                    int temp=num2+num1;
                    st.push(temp);
                }
                else if(tokens[i]=="-"){
                    int temp=num2-num1;
                    st.push(temp);
                }
                else if(tokens[i]=="*"){
                    int temp=num2*num1;
                    st.push(temp);
                }
                else if(tokens[i]=="/"){
                    int temp=num2/num1;
                    st.push(temp);
                }
            }
            else{
                st.push(stoi(tokens[i]));
            }
        }
        int ans=st.top();
        return ans;
    }
};