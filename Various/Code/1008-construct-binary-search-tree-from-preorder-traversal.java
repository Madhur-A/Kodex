
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
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode rx(int[] preorder, int left, int right) {
        if(left > right) { return null; }
        TreeNode root = new TreeNode(preorder[left]);
        int mid = right+1;
        for(int i=left+1; i<right+1; ++i) {
            if(preorder[i] > root.val) { mid = i; break; }
        }
        root.left = rx(preorder, left+1, mid-1);
        root.right = rx(preorder, mid, right);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return rx(preorder, 0, preorder.length - 1);
    }
}

