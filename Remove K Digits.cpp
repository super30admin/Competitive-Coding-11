//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    string removeKdigits(string num, int k) {
        
        if(k>=num.size()){
            return "0";
        }
        
        stack<char> st;
        string answer="";
        
        for(int i=0;i<num.size();i++){
            if(st.empty() && num[i]!='0'){
                st.push(num[i]);
            }
            else if(!st.empty() && num[i]>st.top()){
                st.push(num[i]);
            }
            else{
                while(!st.empty() && k>0 && st.top()>num[i]){
                    st.pop();
                    k--;
                }
                st.push(num[i]);
            }
        }
        
        while(k>0 && !st.empty()){
            st.pop();
            k--;
        }
        
        while(!st.empty()){
            answer+=st.top();
            st.pop();
        }
        
        reverse(answer.begin(),answer.end());
        int count=0;
        for(char ch:answer){
            if(ch=='0'){
                count++;
            }
            else{
                break;
            }
        }
        
        if(count>0){
            answer=answer.substr(count,answer.size());
        }
        return answer.empty()?"0":answer;
        
    }
};