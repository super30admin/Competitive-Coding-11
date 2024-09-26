//Time - O(n)
//Space - O(n)

class Solution {
public:
    string removeKdigits(string num, int k) {
        stack<char> st;
        if(k>=num.size()) return "0";
        
        
        for(int i=0;i<num.size();i++){
            if(k==0){
                st.push(num[i]);
            }else{
                while(k>0 && !st.empty() && num[i]-'0' < st.top()-'0'){
                    st.pop();
                    k--;
                }
                
                while(st.empty() && num[i] == '0' && i<num.size()-1) i++;
                
                
                st.push(num[i]);
            }
        }
        
        while (k-- > 0 && !st.empty()) st.pop();
        
        string str = "";
        while(!st.empty()){
            str = st.top() + str;
            st.pop();
        }
        
        return str;
        
        
    }
};