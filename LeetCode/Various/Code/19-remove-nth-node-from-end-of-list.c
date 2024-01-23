
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
// url: https://leetcode.com/problems/

// note: 

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

int count = 0;

struct ListNode* rx(struct ListNode* r, int n) {
    if(r) {
        r->next = rx(r->next, n);
        ++count;
        if(count == n) { return r->next; }
    }
    return r;
}

struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode* ans = rx(head, n);
    count = 0;
    return ans;
}
