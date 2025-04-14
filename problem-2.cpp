// https://leetcode.com/problems/remove-k-digits/description/

// Time Complexity: O(n+k)
// Space Complexity: O(n-k)


class Solution {
    public:
        string removeKdigits(string num, int k) {
            int n = num.size();
            if (n==k) return "0";
            string ans = "";
            for(auto i:num){
                while(ans.length() > 0 && k > 0 && ans.back() > i){
                    k--;
                    ans.pop_back();
                }
                if(ans.length() > 0 || i != '0') ans.push_back(i);
            }
            while(ans.length() > 0 && k > 0){
                k--;
                ans.pop_back();
            }
            if(ans == "") return "0";
            return ans;
        }
    };