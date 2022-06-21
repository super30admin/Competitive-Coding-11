#include <bits/stdc++.h> 
using namespace std;  

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if(!head) return nullptr;
        if(head->next == nullptr) 
            return head;
        
        // we have at least 2 nodes now; 
        // 1
        ListNode *end_odd = nullptr;
        // 2
        ListNode *start_even = nullptr;
        int i=1;
        ListNode *cur = head;
        // 1, 2, 3, 4, 5
        while(cur != nullptr) {
            if(end_odd == nullptr) {
                end_odd = cur;
            } else if(start_even == nullptr) {
                start_even = cur;
            }
            
            // 2, 3, 4, 5, null
            ListNode *temp = cur->next;
            // 3, 4, 5, null
            if(temp != nullptr)
                cur->next = temp->next;
            else 
                cur->next = nullptr;
            
            
            cur = temp;
            i++;
        }
        
        end_odd->next = start_even;
        return head;
        
        
    }
};