#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use a stack to store digits and keep removing the top if the current digit is smaller and we still have k left.
We remove remaining digits from the end if k is still not zero after the loop.
We build the result by skipping leading zeros and return "0" if everything got removed.
*/
class Solution{
public:
    string removeKdigits(string num, int k){
        vector<char> st;
        for(int i = 0; i < (int)num.size(); i++){
            char c = num[i];
            while(!st.empty() && c < st.back() && k > 0){
                st.pop_back();
                k--;
            }
            st.push_back(c);
        }

        while(k > 0){
            st.pop_back();
            k--;
        }

        string sb;
        bool firstZero = true;
        for(char c : st){
            if(firstZero && c == '0') continue;

            firstZero = false;
            sb.push_back(c);
        }
        if(sb.empty()) return "0";
        return sb;
    }
};
