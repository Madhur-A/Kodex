
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
// url: https://leetcode.com/problems/next-greater-node-in-linked-list

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
    private  ArrayDeque<Integer> ans;
    private int g_max;
    
    public void rx(ListNode r) {
        if(r != null) {
            rx(r.next);
            if(r != null) {
                g_max = Math.max(g_max, r.val);
                if(r.next == null || r.val == g_max) {
                    ans.offer(0);
                } else {
                    ListNode n = r.next;
                    while(n != null && n.val <= r.val) { n = n.next; }
                    int value = (n == null) ? 0 : n.val;
                    ans.offer(value);
                }
            }
        }
        
    }
    public int[] nextLargerNodes(ListNode head) {
        ans = new ArrayDeque<>();
        g_max = Integer.MIN_VALUE;
        rx(head);
        int ix = ans.size();
        int[] res = new int[ix];
        for(int element: ans) { res[--ix] = element; }
        return res;
    }
}
