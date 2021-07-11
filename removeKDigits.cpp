// Time Complexity :O(n) where n in the number elements in the string
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    string removeKdigits(string num, int k) {
        /*if(k >= num.length()) return "0";
        string ans = "";
        stack<char> stk;
        int count = 0;
        for(auto c : num){
           while(!stk.empty() && c < stk.top() && count < k){
                stk.pop();
                count++;
            }
            stk.push(c);
        }
        while(!stk.empty()) {
            ans = stk.top() + ans;
            stk.pop();
        }
        if(ans == "") return "0";
        bool flag = false;
        for(auto c : ans){
            if(c != '0') flag = true;
        }
        if(!flag) return "0";
        int start;
        for(int i = 0;i < ans.length();i++){
            if(ans[i] != '0') {
                start = i;
                break;
            }
        }
        return ans.substr(start,ans.length()-start);*/
        
        //without Stack
        string ans="";
        for(char &c:num)
        {
            while(ans.size() && ans.back()>c &&k)
            {
                ans.pop_back();
                k--;
            }
            if(ans.size()||c!='0')ans.push_back(c);
        }
        while(ans.size()&&k--)           
        {
            ans.pop_back();
        }
        return (ans=="")?"0":ans;
    }
};