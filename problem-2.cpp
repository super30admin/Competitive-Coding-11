//tc: O(n)
//sc: O(n)
class Solution {
public:
    string removeKdigits(string num, int k){
        vector<int> st;
        string result = "";
        for(int i = 0; i < num.size(); i++){
            while(!st.empty() && num[i] < st.back() && k > 0){
                st.pop_back();
                k--;
            }
            st.push_back(num[i]);
        }
        while(k > 0){
            st.pop_back();
            k--;
        }
        for(char ch : st){
            if(result == "" && ch == '0') continue;
            result += ch;
        }
        return result.empty() ? "0": result;
    }
};