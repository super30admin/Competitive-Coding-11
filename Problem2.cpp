// Time Complexity : O(n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Remove K Digits

#include<iostream>
#include<vector>
#include<stack>
#include<string>

using namespace std;

class Solution {
public:
    string removeKdigits(string num, int k) {
        
        //base
        if(k >= num.size())
            return "0";
        
        stack<char> s1;
        string res = "";
        
        for(auto c : num){
            
            while(!s1.empty() && k > 0 && s1.top() > c){
                s1.pop();   // pop the higher element
                --k;
            }
            
            s1.push(c);
        }
        
        // pop if the peak doesn't drop i.e all ascending 
        for(int i = 0; i < k; i++){
            s1.pop();
        }
        
        while(!s1.empty()){
            res = s1.top() + res;
            s1.pop();
            // cout<<"\t"<<res;
        }
        
        
        // Cases  = res = 0200 // res = 1219 // res = 000
        
        bool valid = false;
        
        for(auto c : res){
            if(c != '0')
                valid = true;
        }
        
        if(!valid)
            return "0";
        
        
        int start = 0;
        
        for(int i = 0; i < res.size(); i++){
            if(res[i] != '0'){
                start = i;
                break;
            }
        }
        
        
        return res.substr(start, res.size() - start);
    }
};