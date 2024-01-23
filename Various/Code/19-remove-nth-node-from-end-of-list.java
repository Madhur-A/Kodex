
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
// url: https://leetcode.com/problems/remove-nth-node-from-end-of-list

// note: 


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    private int ix = 0;
    public ListNode rx(ListNode r, int n) {
        if(r != null) {
            r.next = rx(r.next, n);
            ix += 1;
            if(ix == n) {
                return r.next;
            }
        }
        return r;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ix = 0;
        return rx(head, n);
    }
}
