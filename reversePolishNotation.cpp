#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use stack to put the numbers into the stack and then when we encounter an operator
we implement that operation and then again push the result into the stack
then we finally return thee top of the stack once all the operation is done
*/
class Solution{
public:
    int evalRPN(vector<string>& tokens){
        stack<int> st;

        for(int i = 0; i < tokens.size(); i++){
            if(tokens[i] == "+"){
                int num1 = st.top(); st.pop();
                int num2 = st.top(); st.pop();
                st.push(num2 + num1);
            }
            else if(tokens[i] == "-"){
                int num1 = st.top(); st.pop();
                int num2 = st.top(); st.top();
                st.push(num2 - num1);
            }
            else if(tokens[i] == "*"){
                int num1 = st.top(); st.pop();
                int num2 = st.top(); st.top();
                st.push(num2 * num1);
            }
            else if(tokens[i] == "/"){
                int num1 = st.top(); st.pop();
                int num2 = st.top(); st.top();
                st.push(num2 / num1);
            }else{
                st.push(stoi(tokens[i]));
            }
        }
        return st.top();
    }
};
