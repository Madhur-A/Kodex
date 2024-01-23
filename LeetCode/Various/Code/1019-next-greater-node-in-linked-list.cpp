
/*
 *
 * Copyright (c) 2024
 * A. Madhur
 *
 * Permission to use, copy, modify, distribute and sell this software
 * and its documentation for any purpose is hereby granted without fee,
 * provided that the above copyright notice appear in all copies and
 * that both that copyright notice and this permission notice appear
 * in supporting documentation. A. Madhur makes no representations
 * about the suitability of this software for any purpose. It is provided
 * "as is" without express or implied warranty.
 */

// date: 23rd of January, 2024
// url: https://leetcode.com/problems/next-greater-node-in-linked-list/

// note: 

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
    std::deque<int> ans;
    int g_max = INT_MIN;
public:
    inline void rx(ListNode* r) {
        if(r) {
            rx(r->next);
            if(r) {
                g_max = std::max(g_max, r->val);
                if(r->next == nullptr or r->val == g_max) {
                    ans.push_front(0);
                } else {
                    ListNode* n = r->next;
                    while(n and n->val <= r->val) { n = n->next; }
                    (n == nullptr) ? ans.push_front(0) : ans.push_front(n->val);
                }
            }
        }
    }
    vector<int> nextLargerNodes(ListNode* head) {
        std::ios_base::sync_with_stdio(false);
        std::cin.tie(nullptr);
        rx(head);
        return std::vector(ans.begin(), ans.end());
    }
};
