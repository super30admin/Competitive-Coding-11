//TC : O(N)
//SC : O(N)

class Solution {
public:
    string removeKdigits(string num, int k) {
        string res="";
          if(num.length() == k)// if the length of the string is equal to the length of string which we have to return
              return "0"; 
          for (int i = 0; i < num.length(); i++)
          {
              while(res.size()>0  && res.back() > num[i] && k)  //removing all those which digit which are greater than next one 
              {
                     res.pop_back();
					 k--;
              }
              if(res.size() > 0 || num[i]!='0')    
              {
                 res.push_back(num[i]);
              }
          }
           while(res.size() && k )    //maybe there is no digit such that which satify the condition but we have to remove some digt than we are removing last k digit 
           {
              res.pop_back(); 
              k--;
           }
          return res.empty() ? "0" : res;  
    
    }
};